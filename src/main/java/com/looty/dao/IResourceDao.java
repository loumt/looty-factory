package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.Resource;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/30/030
 */
public interface IResourceDao {

    long save(Resource resource) throws DaoException;

    int update(Resource resource) throws DaoException;

    List<Resource> list() throws DaoException;

    List<Resource> list(Resource resource) throws DaoException;

    List<Resource> list(String start, String end) throws DaoException;

    long count() throws DaoException;

    int deleteById(Long id) throws DaoException;
}
