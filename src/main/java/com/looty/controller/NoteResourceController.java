/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.NoteResource;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.INoteResourceService;
import com.looty.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * USED TO:笔记资源
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/4/11/011
 */
@Controller
@RequestMapping(value = "/manage/note/noteResource")
public class NoteResourceController extends BaseController {

    @Autowired
    private INoteResourceService noteResourceService;

    /**
     * 笔记列表
     *
     * @return
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return backViewMV("/note/note_resource_list");
    }

    /**
     * 添加笔记
     *
     * @return
     */
    @RequestMapping("/toWrite")
    public ModelAndView toWrite() {
        return backViewMV("/note/note_resource_write");
    }


    /**
     * 获得笔记资源列表
     *
     * @return
     */
    @RequestMapping(value = "/getNoteResourceList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNoteResourceList() {
        return backDataMap(ResultMsg.isSuccess(noteResourceService.getNoteResourceList(), noteResourceService.getNoteResourceCount()));
    }

    /**
     * 保存笔记资源
     *
     * @param resource
     * @return
     */
    @RequestMapping(value = "/saveNoteResource", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveResource(NoteResource resource) {
        if (StringUtil.isEmpty(resource.getContent()) || StringUtil.isEmpty(resource.getTheme())) {
            return backDataMap(ResultMsg.isFail(ResultMsgEnum.INVALIDATE_PARAMETER));
        }
        //创建时间
        resource.setCreateDate(new Date());
        ResultMsg resultMsg = noteResourceService.saveNoteResource(resource);
        return backDataMap(resultMsg);
    }

    /**
     * 保存笔记资源
     *
     * @param resource
     * @return
     */
    @RequestMapping(value = "/updateNoteResource", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateResource(NoteResource resource) {
        if (StringUtil.isEmpty(resource.getContent()) || StringUtil.isEmpty(resource.getTheme()) || resource.getId() == null) {
            return backDataMap(ResultMsg.isFail(ResultMsgEnum.INVALIDATE_PARAMETER));
        }
        ResultMsg resultMsg = noteResourceService.updateNoteResource(resource);
        return backDataMap(resultMsg);
    }
}
