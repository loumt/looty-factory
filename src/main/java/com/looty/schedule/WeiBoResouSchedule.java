/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.crawler.resou.ResouFactory;
import com.looty.crawler.resou.ResouService;
import com.looty.crawler.resou.WeiBoRule;
import com.looty.pojo.WeiBoResource;
import com.looty.service.IWeiBoResourceService;
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
    private IWeiBoResourceService weiBoResourceService;

    private final String url = "http://s.weibo.com/top";
    private final String methodUrl = "/summary";
    private final String[] params = new String[]{"cate"};
    private final String[] values = new String[]{"realtimehot"};
    private final String resultTagName = "script";
    private final int type = WeiBoRule.SELECTION;
    private final int requestMoethod = WeiBoRule.GET;


    @Scheduled(cron = "0 0/1 * * * ?")
    public void getResou() {
        try {
            Date now = new Date();
            Long count = weiBoResourceService.getCountByDate(now);
            if (count.longValue() == 0L) {
                List<WeiBoResource> result = getDatas();
                if (!CollectionUtils.isEmpty(result)) {
                    weiBoResourceService.saveList(result);
                } else {
                    logger.info("微博热搜今日搜索排行Error!!!!");
                }
            } else {
                logger.info("微博热搜今日搜索排行 " + count + " 条");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("微博热搜今日排行Error!!!!!!!!!"+e.getMessage());
        }
    }


    /**
     * 获取数据
     *
     * @return
     */
    private List<WeiBoResource> getDatas() throws Exception {
        WeiBoRule weiBoRule = new WeiBoRule(url + methodUrl, params, values, resultTagName, type, requestMoethod);
        ResouService service = new ResouService(weiBoRule);
        Document mainDoc = service.getDocument();
        Elements elements = service.getElements(mainDoc);
        List<WeiBoResource> datas = ResouFactory.getInstance().getContents(elements);
        return datas;
    }


}
