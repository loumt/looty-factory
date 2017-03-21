package com.looty.dao;

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
public interface RoleDao {
    long insertRole(Role role);

    int count();

    List<RoleVo> getRoleList();
}
