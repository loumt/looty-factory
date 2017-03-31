package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.Resource;
import com.looty.pojo.system.ResultMsg;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/30/030
 */
public interface IResourceService {

    ResultMsg saveResource(Resource resource) throws ServiceException;

    ResultMsg getResourceList() throws ServiceException;

    long getCount() throws ServiceException;

    List<Resource> getResourceList(Resource resource) throws ServiceException;

    List<Resource> getResourceList(Date start, Date end) throws ServiceException;
}
