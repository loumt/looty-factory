/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.pojo.Role;
import com.looty.vo.RoleVo;
import org.springframework.stereotype.Repository;

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
@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

    private static final String INSERT_ROLE = "insert into role(roleName,roleCode,createUserId,createDate,remark)values(:roleName,:roleCode,:createUserId,:createDate,:remark)";
    public long insertRole(Role role) {
        return this.saveBean(INSERT_ROLE, role);
    }

    private static final String COUNT = "select count(*) from role";

    public Long getCount() {
        return this.queryForObject(COUNT, Long.class);
    }

    private static final String GET_ROLE_LIST = "select re.id,re.roleCode,re.roleName,re.remark,re.createDate,u.realName from role as re left join user as u on u.userId = re.createUserId";

    public List<RoleVo> getRolePageList() {
        return this.queryForPageBeanList(GET_ROLE_LIST, RoleVo.class);
    }
}
