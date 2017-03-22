package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.system.ResultMsg;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/21/021
 */
public interface ISystemLogService {

    ResultMsg getSysLogList() throws ServiceException;
}
