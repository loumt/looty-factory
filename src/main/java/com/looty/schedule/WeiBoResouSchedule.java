/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.crawler.ExtractService;
import com.looty.pojo.LinkTypeData;
import com.looty.pojo.WeiBoRule;
import com.looty.crawler.factory.ResouFactory;
import com.looty.service.ILinkDataTypeService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/3/27/027
 */
@Component
public class WeiBoResouSchedule {

    private Logger logger = Logger.getLogger(WeiBoResouSchedule.class);

    @Autowired
    private ILinkDataTypeService linkDataTypeService;

    private final String url = "http://s.weibo.com/top";
    private final String methodUrl = "/summary";
    private final String[] params = new String[]{"cate"};
    private final String[] values = new String[]{"realtimehot"};
    private final String resultTagName = "script";
    private final int type = WeiBoRule.SELECTION;
    private final int requestMoethod = WeiBoRule.GET;


    /**
     * 获取数据
     *
     * @return
     */
    private List<LinkTypeData> getDatas() {
        WeiBoRule weiBoRule = new WeiBoRule(url + methodUrl, params, values, resultTagName, type, requestMoethod);
        ExtractService service = new ExtractService(weiBoRule);
        Document mavenDoc = service.getDocument();
        Elements elements = service.getElements(mavenDoc);
        List<LinkTypeData> datas = ResouFactory.getInstance().getContents(elements);
        return datas;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void getResou() {
        Date now = new Date();
        Long count = linkDataTypeService.getCountByDate(now);
        System.out.println("DB:" + count + "条");
        if (count.longValue() == 0L) {
            List<LinkTypeData> result = getDatas();
            if (!CollectionUtils.isEmpty(result)) {
                linkDataTypeService.saveList(result);
            } else {
                logger.info("微博热搜今日搜索排行Error!!!!");
            }
        } else {
            logger.info("微博热搜今日搜索排行 " + count + " 条");
        }
    }

}
