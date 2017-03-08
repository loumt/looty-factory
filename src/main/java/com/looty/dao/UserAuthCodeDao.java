package com.looty.dao;

import com.looty.pojo.UserAuthCode;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/7/007
 */
public interface UserAuthCodeDao {
    long saveAuthCode(UserAuthCode userAuthCode);

    UserAuthCode getUserAuthCode(String authCode);

    UserAuthCode getAuthCodeByUsername(String userId);
}
