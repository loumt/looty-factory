package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.SystemStatusLog;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/3/003
 */
public interface ISystemStatusLogService {

    long insertOneSystemStatusLog(SystemStatusLog systemStatusLog) throws ServiceException;

}
