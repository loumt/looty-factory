/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.INoteResourceDao;
import com.looty.exception.DaoException;
import com.looty.pojo.NoteResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao.impl
 * @date 2017/4/11/011
 */
@Repository
public class NoteResourceDaoImpl extends BaseDao implements INoteResourceDao {

    private static final String SAVE = "insert into note_resource(theme,content,remark,createDate)values(:theme,:content,:remark,:createDate)";

    @Override
    public long save(NoteResource noteResource) throws DaoException {
        return this.saveBean(SAVE, noteResource);
    }

    private static final String GET_LIST = "select * from note_resource";

    @Override
    public List<NoteResource> getList() throws DaoException {
        return this.queryForPageBeanList(GET_LIST, NoteResource.class);
    }

    private static final String GET_BY_ID = "select * from note_resource where id = ?";

    @Override
    public NoteResource getById(Long id) throws DaoException {
        Object[] args = {id};
        return this.queryForBean(GET_BY_ID, NoteResource.class, args);
    }

    private static final String DELETE_BY_ID = "delete note_resource where id = ?";

    @Override
    public int deleteById(Long id) throws DaoException {
        Object[] args = {id};
        return this.delete(DELETE_BY_ID, args);
    }

    private static final String GET_COUNT = "select count(*) from note_resource";

    @Override
    public Long getCount() throws DaoException {
        return this.totalCount(GET_COUNT);
    }

    private static final String UPDATE = "update note_resource set theme = ?,content = ? where id = ?";

    @Override
    public int update(NoteResource resource) throws DaoException {
        Object[] args = {resource.getTheme(), resource.getContent(), resource.getId()};
        return this.update(UPDATE, args);
    }
}
