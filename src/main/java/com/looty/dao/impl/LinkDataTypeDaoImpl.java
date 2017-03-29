/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.exception.DaoException;
import com.looty.pojo.LinkTypeData;
import com.looty.dao.ILinkDataTypeDao;
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
public class LinkDataTypeDaoImpl extends BaseDao implements ILinkDataTypeDao {

    private static final String SAVE_RE_SOU_DATA = "insert into link_data_type(summary,content,exponent,ranking)values(:summary,:content,:exponent,:ranking)";

    public long saveResouData(LinkTypeData linkTypeData) {
        return this.saveBean(SAVE_RE_SOU_DATA, linkTypeData);
    }

    private static final String COUNT_BY_DATA = "select count(*) from link_data_type where createDate between ? and ?";

    public Long count(String begin, String end) {
        Object[] args = {begin, end};
        return super.totalCount(COUNT_BY_DATA, args);
    }

    private static final String COUNT = "select count(*) from link_data_type";

    public long count() {
        return this.totalCount(COUNT);
    }

    private static final String LIST = "select * from link_data_type order by createDate desc";

    public List<LinkTypeData> list() throws DaoException {
        return this.queryForPageBeanList(LIST, LinkTypeData.class);
    }

    private static final String LIST_BY_TYPE = "select * from link_data_type where type = ? order by createDate desc";

    public List<LinkTypeData> list(int type) throws DaoException {
        Object[] args = {type};
        return this.queryForPageBeanList(LIST_BY_TYPE, LinkTypeData.class, args);
    }

    private static final String UPDATE_TYPE = "update link_data_type set type = ? where id = ?";

    public int updateType(Long id, int type) throws DaoException {
        Object[] args = {type, id};
        return this.update(UPDATE_TYPE, args);
    }

}
