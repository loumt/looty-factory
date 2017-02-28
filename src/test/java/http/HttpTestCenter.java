/**
 * Copyright (c) www.bugull.com
 */
package http;

import base.BaseJuit4Test;
import com.looty.pojo.HttpResult;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package http
 * @date 2017/2/23/023
 */
public class HttpTestCenter extends BaseJuit4Test {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;


    private HttpTestCenter() {
    }

    public static HttpTestCenter newInstance() {
        return new HttpTestCenter();
    }

    /**
     * GET
     *
     * @param url
     * @return
     */
    public HttpResult sendGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResponse(response);
        }
        return null;
    }

    /**
     * POST
     *
     * @param url
     * @return
     */
    public HttpResult sendPost(String url) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResponse(response);
        }
        return null;
    }


    /**
     * Get
     *
     * @param url
     * @param param
     * @return
     */
    public HttpResult sendGet(String url, Map<String, Object> param) {
        StringBuffer sb = new StringBuffer(url);
        int size = param.size();
        String[] paramStr = new String[size];
        int i = 0;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            paramStr[i] = entry.getKey() + "=" + entry.getValue().toString();
            i++;
        }
        for (int length = 0; length < paramStr.length; length++) {
            if (length == 0) {
                sb.append("?" + paramStr[length]);
            } else if (length == size - 1) {
                sb.append(paramStr[length]);
            } else {
                sb.append(paramStr[length] + "&");
            }
        }
        System.out.println("Get Url:" + sb.toString());

        HttpGet httpGet = new HttpGet(sb.toString());
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResponse(response);
        }
        return null;
    }

    /**
     * POST
     *
     * @param url
     * @param param
     * @return
     */
    public HttpResult sendPost(String url, Map<String, Object> param) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(param.size());
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairList, Charset.forName("utf-8"));
            httpPost.setEntity(urlEncodedFormEntity);

            response = httpClient.execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResponse(response);
        }
        return null;
    }


    /**
     * Close public resource
     *
     * @param response
     */
    private void closeResponse(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
