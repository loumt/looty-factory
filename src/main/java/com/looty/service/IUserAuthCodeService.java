package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.system.ResultMsg;

import java.util.Date;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/7/007
 */
public interface IUserAuthCodeService {

    ResultMsg getAuthCode(String ip, String username) throws ServiceException;

    boolean checkAuthCode(String authCode) throws ServiceException;

    ResultMsg getAuthList() throws ServiceException;

    ResultMsg removeCode(String code) throws ServiceException;

    ResultMsg getCodeInValid(Date date) throws ServiceException;
}
