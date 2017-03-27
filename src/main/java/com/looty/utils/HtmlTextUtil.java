/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

/**
 * USED TO:Html文本工具类
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.utils
 * @date 2017/3/24/024
 */
public final class HtmlTextUtil {

    public static String getTagValue(String regionTxt, String tagName) {
        if (regionTxt.indexOf(tagName) == -1) return "";
        String[] pe = preEnd(tagName);
        int start = regionTxt.indexOf(pe[0]) + pe[0].length();
        int end = regionTxt.indexOf(pe[1]);
        String result = regionTxt.substring(start, end);
        return result;
    }

    private static String[] preEnd(String tagName) {
        return new String[]{"<" + tagName, "</" + tagName + ">"};
    }
}
