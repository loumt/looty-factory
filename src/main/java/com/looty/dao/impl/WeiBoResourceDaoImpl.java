/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.IWeiBoResourceDao;
import com.looty.exception.DaoException;
import com.looty.pojo.WeiBoResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/27/027
 */
@Repository
public class WeiBoResourceDaoImpl extends BaseDao implements IWeiBoResourceDao {

    private static final String SAVE_RE_SOU_DATA = "insert into wei_bo_resource(type,summary,content,exponent,ranking)values(:type,:summary,:content,:exponent,:ranking)";

    public long saveResouData(WeiBoResource weiBoResource) throws DaoException {
        return this.saveBean(SAVE_RE_SOU_DATA, weiBoResource);
    }

    private static final String COUNT_BY_DATA = "select count(*) from wei_bo_resource where createDate between ? and ?";

    public Long count(String begin, String end) throws DaoException {
        Object[] args = {begin, end};
        return super.totalCount(COUNT_BY_DATA, args);
    }

    private static final String COUNT = "select count(*) from wei_bo_resource";

    public Long count() throws DaoException {
        return this.totalCount(COUNT);
    }

    private static final String LIST = "select * from wei_bo_resource order by createDate asc";

    public List<WeiBoResource> list() throws DaoException {
        return this.queryForPageBeanList(LIST, WeiBoResource.class);
    }

    private static final String LIST_BY_TYPE = "select * from wei_bo_resource where type = ? order by createDate desc";

    public List<WeiBoResource> list(int type) throws DaoException {
        Object[] args = {type};
        return this.queryForPageBeanList(LIST_BY_TYPE, WeiBoResource.class, args);
    }

    private static final String UPDATE_TYPE = "update wei_bo_resource set type = ? where id = ?";

    public int updateType(Long id, int type) throws DaoException {
        Object[] args = {type, id};
        return this.update(UPDATE_TYPE, args);
    }

}
