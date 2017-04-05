/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.enums.ResourceEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.WeiBoResource;
import com.looty.dao.IWeiBoResourceDao;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IWeiBoResourceService;
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
public class WeiBoResourceServiceImpl extends BaseService implements IWeiBoResourceService {

    @Autowired
    private IWeiBoResourceDao weiBoResourceDao;


    public long save(WeiBoResource weiBoResource) throws ServiceException {
        return weiBoResourceDao.saveResouData(weiBoResource);
    }

    public void saveList(List<WeiBoResource> datas) {
        for (WeiBoResource data : datas) {
            save(data);
        }

    }

    public Long getCountByDate(Date now) {
        String start = DateUtil.getStart(now);
        String end = DateUtil.getEnd(now);
        return weiBoResourceDao.count(start, end);
    }

    public ResultMsg getDataList(ResourceEnum resourceEnum) throws ServiceException {
        List<WeiBoResource> datas = weiBoResourceDao.list(resourceEnum.getType());
        Long count = weiBoResourceDao.count();
        return ResultMsg.isSuccess(datas, count);
    }


    public int updateType(Long dataId, ResourceEnum resourceEnum) throws ServiceException {
        return weiBoResourceDao.updateType(dataId, resourceEnum.getType());
    }
}
