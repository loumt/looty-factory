/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.dao.INoteResourceDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.NoteResource;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.INoteResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service.impl
 * @date 2017/4/11/011
 */
@Service
public class NoteResourceServiceImpl extends BaseService implements INoteResourceService {

    @Autowired
    private INoteResourceDao noteResourceDao;

    @Override
    public List<NoteResource> getNoteResourceList() throws ServiceException {
        return noteResourceDao.getList();
    }

    @Override
    public Long getNoteResourceCount() throws ServiceException {
        return noteResourceDao.getCount();
    }

    @Override
    public ResultMsg saveNoteResource(NoteResource resource) throws ServiceException {
        long id = noteResourceDao.save(resource);
        return id == 0 ? ResultMsg.isFail(ResultMsgEnum.FAILUE) : ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, id);
    }

    @Override
    public ResultMsg updateNoteResource(NoteResource resource) throws ServiceException {
        int i = noteResourceDao.update(resource);
        return i == 0 ? ResultMsg.isFail(ResultMsgEnum.FAILUE) : ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, i);
    }
}
