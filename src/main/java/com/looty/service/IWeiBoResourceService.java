package com.looty.service;

import com.looty.enums.ResourceEnum;
import com.looty.exception.DaoException;
import com.looty.exception.ServiceException;
import com.looty.pojo.WeiBoResource;
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
 * @date 2017/3/27/027
 */
public interface IWeiBoResourceService {

    long save(WeiBoResource weiBoResource) throws DaoException;

    void saveList(List<WeiBoResource> datas) throws DaoException;

    Long getCountByDate(Date now) throws DaoException;

    ResultMsg getDataList(ResourceEnum resourceEnum) throws ServiceException;

    int updateType(Long id, ResourceEnum resourceEnum) throws ServiceException;
}
