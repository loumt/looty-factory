/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.crawler.LinkTypeData;
import com.looty.dao.ILinkDataTypeDao;
import com.looty.dao.LinkDataTypeDaoImpl;
import com.looty.service.ILinkDataTypeService;
import com.looty.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service.impl
 * @date 2017/3/27/027
 */
@Service
public class LinkDataTypeServiceImpl extends BaseService implements ILinkDataTypeService {

    @Autowired
    private ILinkDataTypeDao linkDataTypeDao;


    public long save(LinkTypeData linkTypeData) {
        return linkDataTypeDao.saveResouData(linkTypeData);
    }

    public void saveList(List<LinkTypeData> datas) {
        for (LinkTypeData data : datas) {
            save(data);
        }

    }

    public Long getCountByDate(Date now) {
        String start = DateUtil.getStart(now);
        String end = DateUtil.getEnd(now);
        return linkDataTypeDao.count(start, end);
    }
}
