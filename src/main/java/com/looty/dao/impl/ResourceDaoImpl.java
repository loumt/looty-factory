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
import java.util.Objects;

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

    private static final String SAVE = "insert into resource(title,des,url,category,destory,createDate)values(:title,:des,:url,:category,:destory,:createDate)";

    @Override
    public long save(Resource resource) throws DaoException {
        return this.saveBean(SAVE, resource);
    }

    @Override
    public int update(Resource resource) throws DaoException {
        return 0;
    }

    private static final String LIST = "select * from resource where destory = 0 order by createDate desc";

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

    private static final String COUNT = "select count(*) from resource where destory = 0";

    @Override
    public long count() throws DaoException {
        return this.queryForObject(COUNT, Long.class);
    }

    private static final String DELETE_BY_ID = "delete from resource where id = ?";

    @Override
    public int deleteById(Long id) throws DaoException {
        Object[] args = {id};
        return this.delete(DELETE_BY_ID, args);
    }

    private static final String GET_BY_ID = "select * from resource where url = ? limit 0,1";

    @Override
    public Resource getByUrl(String url) throws DaoException {
        Object[] arg = {url};
        return this.queryForBean(GET_BY_ID, Resource.class, arg);
    }

    private static final String DESTORY = "update resource set destory = 1 where id = ?";

    @Override
    public int destory(Long id) throws DaoException {
        Object[] args = {id};
        return this.update(DESTORY, args);
    }
}
