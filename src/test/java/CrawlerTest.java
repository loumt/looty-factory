/**
 * Copyright (c) www.bugull.com
 */

import com.looty.crawler.ExtractService;
import com.looty.crawler.factory.ResouFactory;
import com.looty.pojo.LinkTypeData;
import com.looty.pojo.WeiBoRule;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

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
//    private String url = "http://mvnrepository.com";
//    private String methodUrl = "/search";
//    private String[] params = new String[]{"q"};
//    private String[] values = new String[]{"mybatis"};
//    private String resultTagName = "im";
//    private int type = Rule.CLASS;
//    private int requestMoethod = Rule.GET;
//
//    @org.junit.Test
//    public void getDatasByCssQueryUserBaidu() {
//        Rule rule = new Rule(url + methodUrl, params, values, resultTagName, type, requestMoethod);
//
//        ExtractService service = new ExtractService(rule);
//        Document mavenDoc = service.getDocument();
//        Elements elements = service.getElements(mavenDoc);
//        List<LinkTypeData> extracts = MavenJarFactory.getInstance().getContents(elements);
//        for (LinkTypeData extract : extracts) {
//            System.out.println("==============================================");
//            System.out.println("" + extract.getId());
//            System.out.println(url + "" + extract.getLinkHref());
//            System.out.println("" + extract.getLinkText());
//            System.out.println("" + extract.getSummary());
//            System.out.println("" + extract.getContent());
//            System.out.println("==============================================");
//        }
//    }


    private String url = "http://s.weibo.com/top";
    private String methodUrl = "/summary";
    private String[] params = new String[]{"cate"};
    private String[] values = new String[]{"realtimehot"};
    private String resultTagName = "script";
    private int type = WeiBoRule.SELECTION;
    private int requestMoethod = WeiBoRule.GET;

    @Test
    public void getResou() {
        WeiBoRule weiBoRule = new WeiBoRule(url + methodUrl, params, values, resultTagName, type, requestMoethod);

        ExtractService service = new ExtractService(weiBoRule);
        Document mavenDoc = service.getDocument();
        Elements elements = service.getElements(mavenDoc);

        if (elements.size() == 0) {
            System.out.println("==================");
            System.out.println("Elements Size == 0");
            System.out.println("==================");
        } else {
            List<LinkTypeData> extracts = ResouFactory.getInstance().getContents(elements);
        }
    }
}
