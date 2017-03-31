/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.dao.IResourceDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.Resource;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IResourceService;
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
 * @date 2017/3/30/030
 */
@Service
public class ResourceServiceImpl extends BaseService implements IResourceService {
    @Autowired
    private IResourceDao resourceDao;

    @Override
    public ResultMsg saveResource(Resource resource) throws ServiceException {
        if (resource.getCreateDate() == null) {
            resource.setCreateDate(new Date());
        }
        long id = resourceDao.save(resource);
        return id == 0L ? ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, id) : ResultMsg.isFail(ResultMsgEnum.FAILUE);
    }

    @Override
    public ResultMsg getResourceList() throws ServiceException {
        List<Resource> list = resourceDao.list();
        long count = resourceDao.count();
        return ResultMsg.isSuccess(list, count);
    }

    @Override
    public long getCount() throws ServiceException {
        return resourceDao.count();
    }

    @Override
    public List<Resource> getResourceList(Resource resource) throws ServiceException {
        return resourceDao.list(resource);
    }

    @Override
    public List<Resource> getResourceList(Date start, Date end) throws ServiceException {
        return null;
    }
}
