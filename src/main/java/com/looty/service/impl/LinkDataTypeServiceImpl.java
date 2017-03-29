/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.enums.ResourceEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.LinkTypeData;
import com.looty.dao.ILinkDataTypeDao;
import com.looty.pojo.system.ResultMsg;
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

    public ResultMsg getDataList(ResourceEnum resourceEnum) throws ServiceException {
        List<LinkTypeData> datas = linkDataTypeDao.list(resourceEnum.getType());
        long count = linkDataTypeDao.count();
        return ResultMsg.isSuccess(datas, count);
    }


    public int updateType(Long dataId, ResourceEnum resourceEnum) throws ServiceException {
        return linkDataTypeDao.updateType(dataId, resourceEnum.getType());
    }
}
