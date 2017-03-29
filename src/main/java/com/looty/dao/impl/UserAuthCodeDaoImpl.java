/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.IUserAuthCodeDao;
import com.looty.exception.DaoException;
import com.looty.pojo.UserAuthCode;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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
public class UserAuthCodeDaoImpl extends BaseDao implements IUserAuthCodeDao {

    private static final String SAVE_AUTH_CODE = "insert into user_auth_code(userId,lastOperationIp,authCode,createDate,inValidDate)values(:userId,:lastOperationIp,:authCode,:createDate,:inValidDate)";

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

    private static final String GET_AUTH_PAGE_LIST = "select * from user_auth_code order by inValidDate asc";

    public List<UserAuthCode> getAuthPageList() {
        return this.queryForPageBeanList(GET_AUTH_PAGE_LIST, UserAuthCode.class);
    }

    private static final String GET_COUNT = "select count(*) from user_auth_code";

    public Long getCount() {
        return this.totalCount(GET_COUNT);
    }


    private static final String REMOVE_CODE = "delete from user_auth_code where authCode = ";

    public void remove(String code) throws DaoException {
        super.delete(REMOVE_CODE + "'" + code + "'");
    }

    private static final String IN_VALID_CODE = "select * from user_auth_code where inValidDate < ?";

    public List<UserAuthCode> inValidCode(Date date) {
        Object[] args = {date};
        return this.queryForBeanList(IN_VALID_CODE, UserAuthCode.class, args);
    }
}
