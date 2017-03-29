package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.ManageLog;
import com.looty.pojo.system.ResultMsg;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/2/17/017
 */
public interface IManageLogService {

    long insertLog(ManageLog bean) throws ServiceException;

    void deleteById(Long manLogId);

    long getCount();


    ResultMsg getManLogList();
}
