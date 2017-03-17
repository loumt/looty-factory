/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.pojo.Role;
import org.springframework.stereotype.Repository;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/8/008
 */
@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

    private static final String INSERT_ROLE = "insert into role(roleName,roleCode,createUserId,createDate,remark)values(:roleName,:roleCode,:createUserId,:createDate,:remark)";

    public long insertRole(Role role) {
        return this.saveBean(INSERT_ROLE, role);
    }

    private static final String COUNT = "select count(*) from role";

    public int count() {
        return this.queryForInteger(COUNT);
    }
}
