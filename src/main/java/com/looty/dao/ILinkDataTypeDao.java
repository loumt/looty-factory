package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.LinkTypeData;

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
public interface ILinkDataTypeDao {

    long saveResouData(LinkTypeData linkTypeData);


    Long count(String begin, String end);

    long count() throws DaoException;


    List<LinkTypeData> list() throws DaoException;

    List<LinkTypeData> list(int type) throws DaoException;

    int updateType(Long id, int type) throws DaoException;
}
