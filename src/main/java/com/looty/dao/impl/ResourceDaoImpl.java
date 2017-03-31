/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.IResourceDao;
import com.looty.exception.DaoException;
import com.looty.pojo.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao.impl
 * @date 2017/3/30/030
 */
@Repository
public class ResourceDaoImpl extends BaseDao implements IResourceDao {

    private static final String SAVE = "insert into resource(title,des,url,category,createDate)values(:title,:des,:url,:category,:createDate)";

    @Override
    public long save(Resource resource) throws DaoException {
        return this.saveBean(SAVE, resource);
    }

    @Override
    public int update(Resource resource) throws DaoException {
        return 0;
    }

    private static final String LIST = "select * from resource order by createDate desc";

    @Override
    public List<Resource> list() throws DaoException {
        return this.queryForPageBeanList(LIST, Resource.class);
    }

    @Override
    public List<Resource> list(Resource resource) throws DaoException {
        return null;
    }

    @Override
    public List<Resource> list(String start, String end) throws DaoException {
        return null;
    }

    private static final String COUNT = "select count(*) from resource";

    @Override
    public long count() throws DaoException {
        return this.queryForObject(COUNT, Long.class);
    }
}
