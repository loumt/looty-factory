package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.UserAuthCode;

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
public interface IUserAuthCodeDao {
    long saveAuthCode(UserAuthCode userAuthCode);

    UserAuthCode getUserAuthCode(String authCode);

    UserAuthCode getAuthCodeByUsername(String userId);

    List<UserAuthCode> getAuthPageList();

    Long getCount();

    void remove(String code) throws DaoException;

    List<UserAuthCode> inValidCode(Date date);
}
