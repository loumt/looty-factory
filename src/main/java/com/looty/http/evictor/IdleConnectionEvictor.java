/**
 * Copyright (c) www.bugull.com
 */
package com.looty.http.evictor;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.http.evictor
 * @date 2017/3/2/002
 */
public class IdleConnectionEvictor extends Thread {

    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        this.start();
    }

    public void run() {
        System.out.println("HttpClient Close Thread Start......");
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        System.out.println("HttpClient Close Thread End......");
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}
