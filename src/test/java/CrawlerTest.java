/**
 * Copyright (c) www.bugull.com
 */

import com.looty.crawler.ElementsUtil;
import com.looty.crawler.ExtractService;
import com.looty.crawler.LinkTypeData;
import com.looty.crawler.Rule;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/13/013
 */
public class CrawlerTest {
    private String url = "http://mvnrepository.com";
    private String methodUrl = "/search";
    private String[] params = new String[]{"q"};
    private String[] values = new String[]{"mybatis"};
    private String resultTagName = "im";
    private int type = Rule.CLASS;
    private int requestMoethod = Rule.GET;

    @org.junit.Test
    public void getDatasByCssQueryUserBaidu() {
        Rule rule = new Rule(url + methodUrl, params, values, resultTagName, type, requestMoethod);
        List<LinkTypeData> extracts = ElementsUtil.getContents(ExtractService.extract(rule));
        for (LinkTypeData extract : extracts) {
            System.out.println("==============================================");
            System.out.println("" + extract.getId());
            System.out.println(url + "" + extract.getLinkHref());
            System.out.println("" + extract.getLinkText());
            System.out.println("" + extract.getSummary());
            System.out.println("" + extract.getContent());
            System.out.println("==============================================");
        }

    }

}
