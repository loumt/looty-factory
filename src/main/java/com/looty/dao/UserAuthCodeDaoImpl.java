/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.pojo.UserAuthCode;
import org.springframework.stereotype.Repository;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/7/007
 */
@Repository
public class UserAuthCodeDaoImpl extends BaseDao implements UserAuthCodeDao {

    private static final String SAVE_AUTH_CODE = "insert into user_auth_code(userId,lastOperationIp,authCode,createDate,inValidData)values(:userId,:lastOperationIp,:authCode,:createDate,:inValidData)";

    public long saveAuthCode(UserAuthCode userAuthCode) {
        return this.saveBean(SAVE_AUTH_CODE, userAuthCode);
    }

    private static final String GET_USER_AUTH_CODE = "select * from user_auth_code where authCode = ?";

    public UserAuthCode getUserAuthCode(String authCode) {
        Object[] arg = {authCode};
        return this.queryForBean(GET_USER_AUTH_CODE, UserAuthCode.class, arg);
    }

    private static final String GET_AUTH_CODE_BY_USERNAME = "select * from user_auth_code where userId = ?";

    public UserAuthCode getAuthCodeByUsername(String userId) {
        Object[] arg = {userId};
        return this.queryForBean(GET_AUTH_CODE_BY_USERNAME, UserAuthCode.class, arg);
    }
}
