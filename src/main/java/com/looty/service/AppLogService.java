package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.AppLog;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/2/17/017
 */
public interface AppLogService {

    long insertOneAppLog(AppLog bean) throws ServiceException;

    void deleteOneAppLog(Long appLogId);
}
