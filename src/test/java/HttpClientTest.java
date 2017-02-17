/**
 * Copyright (c) www.bugull.com
 */

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/16/016
 */

public class HttpClientTest {

    private static CloseableHttpClient closeableHttpClient;

    @Before
    public void setHttpClient() {
        closeableHttpClient = HttpClients.createDefault();
    }

    @Test
    public void sendPost() {

    }

}
