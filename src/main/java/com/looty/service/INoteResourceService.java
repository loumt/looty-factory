package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.NoteResource;
import com.looty.pojo.system.ResultMsg;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/4/11/011
 */
public interface INoteResourceService {
    /**
     * 获得笔记资源列表
     *
     * @return
     */
    List<NoteResource> getNoteResourceList() throws ServiceException;

    /**
     * 获得笔记资源数量
     *
     * @return
     */
    Long getNoteResourceCount() throws ServiceException;


    /**
     * 保存笔记资源
     *
     * @param resource
     * @return ResultMsg
     * @throws ServiceException
     */
    ResultMsg saveNoteResource(NoteResource resource) throws ServiceException;

    /**
     * 更新Resource
     *
     * @param resource
     * @return
     * @throws ServiceException
     */
    ResultMsg updateNoteResource(NoteResource resource) throws ServiceException;
}
