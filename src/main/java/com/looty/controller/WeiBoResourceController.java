/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.enums.ResourceEnum;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IWeiBoResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * USED TO:微博数据扒取
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/29/029
 */
@Controller
@RequestMapping("/manage/weibo")
public class WeiBoResourceController extends BaseController {

    @Autowired
    private IWeiBoResourceService weiBoResourceService;

    /**
     * 微博实时热搜首页
     *
     * @return
     */
    @RequestMapping("/hot/toIndex")
    public ModelAndView toIndex() {
        return backViewMV("/weibo/real_hot_index");
    }

    /**
     * 获取微博实时热搜列表
     *
     * @return
     */
    @RequestMapping(value = "/hot/getRealHotList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRealHotList() {
        ResultMsg resultMsg = weiBoResourceService.getDataList(ResourceEnum.S_WEI_BO_HOT);
        return backDataMap(resultMsg);
    }
}
