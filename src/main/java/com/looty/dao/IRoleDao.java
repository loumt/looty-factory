package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.Role;
import com.looty.vo.RoleVo;

import java.util.List;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/8/008
 */
public interface IRoleDao {
    long insertRole(Role role) throws DaoException;

    Long getCount() throws DaoException;

    List<RoleVo> getRolePageList() throws DaoException;
}
