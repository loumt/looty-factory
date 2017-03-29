package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.ManageLog;

import java.util.List;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/8/008
 */
public interface IManageLogDao {

    long insert(ManageLog manageLog) throws DaoException;

    long count() throws DaoException;

    List<ManageLog> list() throws DaoException;
}
