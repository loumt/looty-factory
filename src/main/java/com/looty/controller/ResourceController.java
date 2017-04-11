/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.annotation.AuthCheck;
import com.looty.base.BaseController;
import com.looty.enums.CategoryEnum;
import com.looty.enums.ModuleEnum;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.Resource;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IResourceService;
import com.looty.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/30/030
 */
@Controller
@RequestMapping("/manage/note/resource")
public class ResourceController extends BaseController {

    @Autowired
    private IResourceService resourceService;

    /**
     * 列表主页
     *
     * @return
     */
    @AuthCheck(modules = ModuleEnum.ARTICLE_MODULE)
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return super.backViewMV("/note/resource_list");
    }


    /**
     * 添加主页
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        return super.backViewMV("/note/resource_add");
    }


    /**
     * 列表
     *
     * @return
     */
    @AuthCheck(modules = ModuleEnum.ARTICLE_MODULE)
    @RequestMapping(value = "/getResourceList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getInfoList() {
        ResultMsg resultMsg = resourceService.getResourceList();
        return super.backDataMap(resultMsg);
    }

    /**
     * 获取文章种类
     *
     * @return
     */
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCategory() {
        Map<String, Object> resultMap = new HashMap<>();
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            resultMap.put(String.valueOf(categoryEnum.getCategory()), categoryEnum.getDes());
        }
        return resultMap;
    }

    /**
     * 保存资源
     *
     * @param resource
     * @return
     */
    @RequestMapping(value = "/add/resource", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addResource(Resource resource) {
        String url = resource.getUrl();
        if (StringUtil.isEmpty(url)) {
            return backDataMap(ResultMsg.isFail(ResultMsgEnum.INVALIDATE_PARAMETER));
        }
        Resource dbResource = resourceService.getResourceByUrl(url);
        if (dbResource != null) {
            return backDataMap(ResultMsg.isFail(ResultMsgEnum.ALREADY_EXIST));
        }
        ResultMsg resultMsg = resourceService.saveResource(resource);
        if (resultMsg.getSuccess()) {
            logger.info("创建资源 " + resultMsg.getData());
        }
        return super.backDataMap(resultMsg);
    }

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/resource", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addResource(@RequestParam() Long id) {
        ResultMsg resultMsg;
        int count = resourceService.destoryResource(id);
        if (count == 1) {
            resultMsg = ResultMsg.isCommonSuccess();
        } else {
            resultMsg = ResultMsg.isFail(ResultMsgEnum.FAILUE);
        }
        return super.backDataMap(resultMsg);
    }

}
