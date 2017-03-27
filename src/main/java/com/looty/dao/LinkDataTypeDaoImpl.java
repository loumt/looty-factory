/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.crawler.LinkTypeData;
import com.looty.service.ILinkDataTypeService;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    private static final String COUNT = "select count(*) from link_data_type where createDate between ? and ?";

    public Long count(String begin, String end) {
        Object[] args = {begin, end};
        return super.totalCount(COUNT, args);
    }

}
