/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.utils
 * @date 2017/3/30/030
 */
public class HttpUrlUtil {


    /**
     * 检测网址是否存在
     *
     * @param url
     * @return
     */
    public boolean checkUrlExist(String url) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }

}
