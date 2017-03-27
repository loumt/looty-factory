/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler.factory;

import com.looty.crawler.LinkTypeData;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * USED TO: Maven Jar
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.crawler.factory
 * @date 2017/3/24/024
 */
public class MavenJarFactory extends AbsFactory {
    private MavenJarFactory() {
    }

    public static MavenJarFactory getInstance() {
        return new MavenJarFactory();
    }


    public List<LinkTypeData> getContents(Elements results) {
        List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
        LinkTypeData data = null;
        for (Element result : results) {
            data = new LinkTypeData();
            Elements aElements = result.getElementsByTag("a");
            for (Element element : aElements) {
                String href = element.attr("href");
                if (href.startsWith("/artifact")) {
                    data.setLinkHref(href);
                    break;
                }
            }
            Elements bElements = result.getElementsByTag("b");
            for (Element bElement : bElements) {
                data.setSummary(bElement.text());
            }
            Elements elementsByClass = result.getElementsByClass("im-title");
            for (Element elementsByClas : elementsByClass) {
                Element child = elementsByClas.child(1);
                data.setContent(child.text());
            }
            datas.add(data);
        }
        return datas;
    }
}
