package com.looty.service;

import com.looty.enums.ResourceEnum;
import com.looty.exception.DaoException;
import com.looty.exception.ServiceException;
import com.looty.pojo.LinkTypeData;
import com.looty.pojo.system.ResultMsg;
import org.springframework.stereotype.Service;

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
public interface ILinkDataTypeService {

    long save(LinkTypeData linkTypeData) throws DaoException;

    void saveList(List<LinkTypeData> datas) throws DaoException;

    Long getCountByDate(Date now) throws DaoException;

    ResultMsg getDataList(ResourceEnum resourceEnum) throws ServiceException;

    int updateType(Long id, ResourceEnum resourceEnum) throws ServiceException;
}