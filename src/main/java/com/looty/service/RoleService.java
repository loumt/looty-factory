package com.looty.service;

import com.looty.pojo.Role;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/8/008
 */
public interface RoleService {

    long insertRole(Role role);

    void deleteRole(long id);

    int count();
}
