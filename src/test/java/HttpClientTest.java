/**
 * Copyright (c) www.bugull.com
 */

import com.looty.pojo.HttpResult;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package springTest
 * @date 2017/2/22/022
 */
public class HttpClientTest extends BaseJuit4Test {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;

    @Test
    public void taobaoIpTest() {

        String ipSeachUrl = "http://ip.taobao.com/service/getIpInfo.php?ip=#IP_ADDRESS#";
        String ip_Str = "#IP_ADDRESS#";

        String ip = "156.158.1.5";

        HttpGet httpGet = new HttpGet(ipSeachUrl.replace(ip_Str, ip));
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            System.out.println(new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8")));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
