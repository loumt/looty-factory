/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler;

import com.looty.utils.StringUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhy
 */
public class ExtractService {

    private Rule rule;

    public ExtractService(Rule rule) {
        // 进行对rule的必要校验
        validateRule(rule);
        this.rule = rule;
    }


    /**
     * 获取对应地址的Doc为文档
     *
     * @return
     */
    public Document getDocument() {
        try {
            String url = rule.getUrl();
            String[] params = rule.getParams();
            String[] values = rule.getValues();
            int requestType = rule.getRequestMoethod();

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
                case Rule.GET:
                    doc = conn.timeout(100000).ignoreContentType(true).parser(Parser.htmlParser()).get();
                    break;
                case Rule.POST:
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
        int type = rule.getType();
        String resultTagName = rule.getResultTagName();

        switch (type) {
            case Rule.CLASS:
                results = doc.getElementsByClass(resultTagName);
                break;
            case Rule.ID:
                Element result = doc.getElementById(resultTagName);
                results.add(result);
                break;
            case Rule.SELECTION:
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
    private static void validateRule(Rule rule) {
        String url = rule.getUrl();
        if (StringUtil.isEmpty(url)) {
            throw new RuleException("url不能为空！");
        }
        if (!url.startsWith("http://")) {
            throw new RuleException("url的格式不正确！");
        }

        if (rule.getParams() != null && rule.getValues() != null) {
            if (rule.getParams().length != rule.getValues().length) {
                throw new RuleException("参数的键值对个数不匹配！");
            }
        }

    }

}