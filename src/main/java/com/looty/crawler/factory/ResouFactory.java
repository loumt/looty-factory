/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler.factory;

import com.looty.enums.ResourceEnum;
import com.looty.pojo.WeiBoResource;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * USED TO:热搜Html 解析
 * Log File:
 * <p>
 * Desc:
 * 热搜。。。。微博热搜排行榜
 * Html使用js渲染
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.crawler.factory
 * @date 2017/3/24/024
 */
public class ResouFactory extends AbsFactory {

    private static ResouFactory resouFactory = null;

    private ResouFactory() {
    }

    public static ResouFactory getInstance() {
        if (resouFactory == null) {
            synchronized (ResouFactory.class) {
                if (resouFactory == null) {
                    resouFactory = new ResouFactory();
                }
            }
        }
        return resouFactory;
    }


    public List<WeiBoResource> getContents(Elements results) {
        Long now = System.currentTimeMillis();
        Date nowDate = new Date(now);
        List<WeiBoResource> datas = new ArrayList<WeiBoResource>();
        WeiBoResource data = null;

        Element target = results.get(13);
        String convertContent = ResouFactory.convertUnicode(target.toString());

        String startCode = "<table";
        int start = convertContent.indexOf(startCode);
        int endCodeLength = "</table>".length();
        int end = convertContent.indexOf("</table>");

        String tableHtml = convertContent.substring(start, end + endCodeLength);

        String[] contextArr = tableHtml.split("<tr action-type=\"hover\">");

        for (int i = 1; i < contextArr.length; i++) {
            String trText = contextArr[i];
            String[] tdArrs = getTdList(trText);
            String sort = getEleValue(tdArrs[0], "em");
            String context = getListValue(tdArrs[1]);
            String exponent = getEleValue(tdArrs[2], "span");

            data = new WeiBoResource();
            data.setContent(context);
            data.setRanking(Integer.valueOf(sort));
            data.setExponent(exponent);
            data.setCreateDate(nowDate);
            data.setType(ResourceEnum.S_WEI_BO_HOT.getType());
            datas.add(data);
        }

        return datas;
    }


    private String getListValue(String regionText) {
        String[] pArr = {"<p class=\"star_name\">", "</p>"};
        String[] aArr = {"<a", "</a>"};
        StringBuffer sb = new StringBuffer(regionText);

        sb.delete(0, sb.indexOf(aArr[0]));
        sb.delete(sb.indexOf(aArr[1]), sb.length());

        String result = sb.substring(sb.lastIndexOf(">") + 1, sb.length());
        return result;
    }


    private String[] getTdList(String trText) {
        StringBuffer sb = new StringBuffer(trText);

        int p1 = sb.indexOf(TdEnum.TD_01.getPre());
        int e1 = sb.indexOf(TdEnum.TD_01.getEnd()) + 5;
        String td_01 = sb.substring(p1, e1);
        sb.delete(p1, e1);

        int p2 = sb.indexOf(TdEnum.TD_02.getPre());
        int e2 = sb.indexOf(TdEnum.TD_02.getEnd()) + 5;
        String td_02 = sb.substring(p2, e2);
        sb.delete(p2, e2);

        int p3 = sb.indexOf(TdEnum.TD_03.getPre());
        int e3 = sb.indexOf(TdEnum.TD_03.getEnd()) + 5;
        String td_03 = sb.substring(p3, e3);
        sb.delete(p3, e3);

        int p4 = sb.indexOf(TdEnum.TD_04.getPre());
        int e4 = sb.indexOf(TdEnum.TD_04.getEnd()) + 5;
        String td_04 = sb.substring(p4, e4);
        sb.delete(p4, e4);

        int p5 = sb.indexOf(TdEnum.TD_05.getPre());
        int e5 = sb.indexOf(TdEnum.TD_05.getEnd()) + 5;
        String td_05 = sb.substring(p5, e5);
        sb.delete(p5, e5);

        return new String[]{td_01, td_02, td_03, td_04, td_05};
    }


    private enum TdEnum {
        TD_01("<td class=\"td_01\">", "</td>"),
        TD_02("<td class=\"td_02\">", "</td>"),
        TD_03("<td class=\"td_03\">", "</td>"),
        TD_04("<td class=\"td_04\">", "</td>"),
        TD_05("<td class=\"td_05\">", "</td>");

        private String pre;
        private String end;

        TdEnum(String pre, String end) {
            this.pre = pre;
            this.end = end;
        }

        public String getPre() {
            return this.pre;
        }

        public String getEnd() {
            return this.end;
        }

    }


    private static String getEleValue(String regionText, String tagName) {
        String[] s = {"<" + tagName + ">", "</" + tagName + ">"};
        int i = regionText.indexOf(s[0]);
        int i1 = regionText.indexOf(s[1]);
        String s1 = regionText.substring(i + s[0].length(), i1);
        return s1;
    }
}
