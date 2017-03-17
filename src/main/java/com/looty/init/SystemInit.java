/**
 * Copyright (c) www.bugull.com
 */
package com.looty.init;

import com.looty.enums.SystemStatusEnum;
import com.looty.pojo.SystemStatusLog;
import com.looty.service.SystemStatusLogService;
import com.looty.utils.ApplicationUtil;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.Enumeration;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.init
 * @date 2017/3/3/003
 */
@WebListener
public class SystemInit implements ServletContextListener {

    /**
     * 容器启动
     *
     * @param sc
     */
    public void contextInitialized(ServletContextEvent sc) {
        ServletContext servletContext = sc.getServletContext();
        String serverInfo = servletContext.getServerInfo();
        String servletContextName = servletContext.getServletContextName();

        ApplicationContext applicationContext = ApplicationUtil.getApplicationContext(servletContext);

        //系统启动日志
        SystemStatusLogService systemStatusLogService = applicationContext.getBean(SystemStatusLogService.class);
        SystemStatusLog systemStatusLog = createSystemStatusLog(SystemStatusEnum.START, serverInfo, servletContextName);
        systemStatusLogService.insertOneSystemStatusLog(systemStatusLog);
    }

    /**
     * 容器关闭
     *
     * @param sc
     */
    public void contextDestroyed(ServletContextEvent sc) {
        SystemStatusLogService systemStatusLogService = getApplicationContext(sc).getBean(SystemStatusLogService.class);
        systemStatusLogService.insertOneSystemStatusLog(createSystemStatusLog(SystemStatusEnum.CLOSE));
    }

    private ApplicationContext getApplicationContext(ServletContextEvent sc) {
        return ApplicationUtil.getApplicationContext(sc.getServletContext());
    }

    private SystemStatusLog createSystemStatusLog(SystemStatusEnum systemStatusEnum, String serverInfo, String contextName) {
        SystemStatusLog statusLog = new SystemStatusLog();
        statusLog.setOperationTime(new Date());
        statusLog.setServerInfo(serverInfo);
        statusLog.setContextName(contextName);
        statusLog.setStatusAction(systemStatusEnum.getStatusAction());
        return statusLog;
    }

    private SystemStatusLog createSystemStatusLog(SystemStatusEnum systemStatusEnum) {
        SystemStatusLog statusLog = new SystemStatusLog();
        statusLog.setOperationTime(new Date());
        statusLog.setStatusAction(systemStatusEnum.getStatusAction());
        return statusLog;
    }
}
