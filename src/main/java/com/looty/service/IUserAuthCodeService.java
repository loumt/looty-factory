package com.looty.service;

import com.looty.pojo.system.ResultMsg;

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

    ResultMsg getAuthCode(String ip, String username);

    boolean checkAuthCode(String authCode);

    ResultMsg getAuthList();
}
