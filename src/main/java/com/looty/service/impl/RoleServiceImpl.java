/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.RoleDao;
import com.looty.pojo.Role;
import com.looty.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/8/008
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public long insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    public void deleteRole(long id) {

    }

    public int count() {
        return roleDao.count();
    }
}
