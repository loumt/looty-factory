/**
 * Copyright (c) www.bugull.com
 */
package com.looty.client;

import com.looty.pojo.TradeMsg;
import com.looty.service.TradeMsgService;
import com.looty.thread.TradeMsgThread;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * USED TO:处理交易的消息缓冲处理
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.client
 * @date 2017/4/12/012
 */
public class TradeMsgClient {

    private static TradeMsgClient client = new TradeMsgClient();

    private TradeMsgClient() {
    }

    public static TradeMsgClient getInstance() {
        return client;
    }


    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 12;
    private static final int KEEP_ACTIVE_TIME = 0;
    private static final int WORK_QUEUE_SIZE = 10;

    //消息队列
    final Queue<TradeMsgThread> msgThreadQueue = new ConcurrentLinkedQueue<>();

    private boolean hasQueueAcquire() {
        return !msgThreadQueue.isEmpty();
    }

    final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            msgThreadQueue.offer((TradeMsgThread) r);
        }
    };


    final ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ACTIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(WORK_QUEUE_SIZE), this.handler);

    /**
     * 定时调度的线程
     */
    final Runnable accessThread = new Runnable() {
        @Override
        public void run() {
            if (hasQueueAcquire()) {
                TradeMsgThread thread = msgThreadQueue.poll();

                TradeMsg tradeMsg = thread.getTradeMsg();
                System.out.println(tradeMsg.getUserId() + "被ScheduledThreadPool执行了");

                pool.execute(thread);
            } else {
                System.out.println("ScheduledThreadPool没任务执行了");
            }
        }
    };
    final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(100);
    final ScheduledFuture future = schedule.scheduleAtFixedRate(accessThread, 1, 1, TimeUnit.SECONDS);


    /**
     * 添加线程任务
     *
     * @param tradeMsg
     */
    public void addTrade(TradeMsgService tradeMsgService, TradeMsg tradeMsg) {
        TradeMsgThread msgThread = new TradeMsgThread(tradeMsgService, tradeMsg);
        pool.execute(msgThread);
    }


    public void saveUnCompileTask() {

    }

}
