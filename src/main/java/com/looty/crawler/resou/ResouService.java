/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler.resou;

import com.looty.exception.WeiBoRuleException;
import com.looty.pojo.WeiBoRule;
import com.looty.utils.StringUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author zhy
 */
public class ResouService {

    private WeiBoRule weiBoRule;

    public ResouService(WeiBoRule weiBoRule) {
        // 进行对rule的必要校验
        validateRule(weiBoRule);
        this.weiBoRule = weiBoRule;
    }


    /**
     * 获取对应地址的Doc为文档
     *
     * @return
     */
    public Document getDocument() {
        try {
            String url = weiBoRule.getUrl();
            String[] params = weiBoRule.getParams();
            String[] values = weiBoRule.getValues();
            int requestType = weiBoRule.getRequestMoethod();

            Connection conn = Jsoup.connect(url);
            // 设置查询参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    conn.data(params[i], values[i]);
                }
            }
            // 设置请求类型
            Document doc = null;
            switch (requestType) {
                case WeiBoRule.GET:
                    doc = conn.timeout(100000).ignoreContentType(true).parser(Parser.htmlParser()).get();
                    break;
                case WeiBoRule.POST:
                    doc = conn.timeout(100000).ignoreContentType(true).post();
                    break;
            }
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取对应Rule中的节点（ID,CLass,Tag）
     *
     * @param doc
     * @return
     */
    public Elements getElements(Document doc) {
        Elements results = new Elements();
        int type = weiBoRule.getType();
        String resultTagName = weiBoRule.getResultTagName();

        switch (type) {
            case WeiBoRule.CLASS:
                results = doc.getElementsByClass(resultTagName);
                break;
            case WeiBoRule.ID:
                Element result = doc.getElementById(resultTagName);
                results.add(result);
                break;
            case WeiBoRule.SELECTION:
                results = doc.select(resultTagName);
                break;
            default:
                if (StringUtil.isEmpty(resultTagName)) {
                    results = doc.getElementsByTag("body");
                }
        }
        return results;
    }

    /**
     * 对传入的参数进行必要的校验
     */
    private static void validateRule(WeiBoRule weiBoRule) {
        String url = weiBoRule.getUrl();
        if (StringUtil.isEmpty(url)) {
            throw new WeiBoRuleException("url不能为空！");
        }
        if (!url.startsWith("http://")) {
            throw new WeiBoRuleException("url的格式不正确！");
        }

        if (weiBoRule.getParams() != null && weiBoRule.getValues() != null) {
            if (weiBoRule.getParams().length != weiBoRule.getValues().length) {
                throw new WeiBoRuleException("参数的键值对个数不匹配！");
            }
        }

    }

}