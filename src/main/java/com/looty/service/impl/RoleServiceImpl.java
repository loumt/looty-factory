/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.IRoleDao;
import com.looty.pojo.Role;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    public long insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    public void deleteRole(long id) {

    }

    public Long getRoleCount() {
        return roleDao.getCount();
    }

    public ResultMsg getRoleList() {
        return ResultMsg.isSuccess(roleDao.getRolePageList(), roleDao.getCount());
    }
}
