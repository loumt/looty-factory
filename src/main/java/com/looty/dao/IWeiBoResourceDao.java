package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.WeiBoResource;

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
public interface IWeiBoResourceDao {

    /**
     * 保存一条资源,并返回生成的ID号
     *
     * @param weiBoResource
     * @return
     * @throws DaoException
     */
    long saveResouData(WeiBoResource weiBoResource) throws DaoException;


    /**
     * 时间阶段内的资源数
     * @param begin 开始时间yyyy-MM-dd HH:mm:ss
     * @param end 结束时间yyyy-MM-dd HH:mm:ss
     * @return
     * @throws DaoException
     */
    Long count(String begin, String end) throws DaoException;

    /**
     * 总条数
     *
     * @return
     * @throws DaoException
     */
    Long count() throws DaoException;


    /**
     * 返回分页内的资源列表
     * @return
     * @throws DaoException
     */
    List<WeiBoResource> list() throws DaoException;

    List<WeiBoResource> list(int type) throws DaoException;

    int updateType(Long id, int type) throws DaoException;
}
