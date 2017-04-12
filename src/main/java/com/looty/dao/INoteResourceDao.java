package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.NoteResource;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/4/11/011
 */
public interface INoteResourceDao {

    /**
     * 保存笔记
     *
     * @param noteResource
     * @return
     * @throws DaoException
     */
    long save(NoteResource noteResource) throws DaoException;

    /**
     * 获取笔记集合
     *
     * @return
     * @throws DaoException
     */
    List<NoteResource> getList() throws DaoException;

    /**
     * 根据ID获取笔记
     *
     * @return
     * @throws DaoException
     */
    NoteResource getById(Long id) throws DaoException;

    /**
     * 根据笔记Id删除笔记
     *
     * @param id
     * @return
     * @throws DaoException
     */
    int deleteById(Long id) throws DaoException;


    /**
     * 获得笔记数量
     *
     * @return
     * @throws DaoException
     */
    Long getCount() throws DaoException;

    /**
     * 更新资源
     *
     * @param resource
     * @return
     * @throws DaoException
     */
    int update(NoteResource resource) throws DaoException;
}
