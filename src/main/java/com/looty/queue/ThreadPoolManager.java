/**
 * Copyright (c) www.bugull.com
 */
package com.looty.queue;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolManager {

    private static ThreadPoolManager tpm = new ThreadPoolManager();

    /**
     * 私有化构造器
     */
    private ThreadPoolManager() {
    }

    /**
     * 获取本类实例化对象
     *
     * @return
     */
    public static ThreadPoolManager newInstance() {
        return tpm;
    }


    // 线程池维护线程的最少数量
    private final static int CORE_POOL_SIZE = 4;

    // 线程池维护线程的最大数量
    private final static int MAX_POOL_SIZE = 10;

    // 线程池维护线程所允许的空闲时间
    private final static int KEEP_ALIVE_TIME = 0;

    // 线程池所使用的缓冲队列大小
    private final static int WORK_QUEUE_SIZE = 10;

    // 消息缓冲队列
    Queue<String> msgQueue = new LinkedList<String>();


    //拒绝执行时的处理过程
    //重新放入msgQueue中等待下一次执行
    final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(((AccessDBThread) r).getMsg() + "消息放入队列中重新等待执行");
            msgQueue.offer(((AccessDBThread) r).getMsg());
        }
    };
    // 管理数据库访问的线程池
    @SuppressWarnings({"rawtypes", "unchecked"})
    final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue(WORK_QUEUE_SIZE), this.handler);




    // 访问消息缓存的调度线程
    // 查看是否有待定请求，如果有，则创建一个新的AccessDBThread，并添加到线程池中
    final Runnable accessBufferThread = new Runnable() {
        public void run() {
            System.out.println(LocalTime.now() + "调度accessBufferThread 此时Queue size :" + getQueueLength());
            if (hasMoreAcquire()) {
                String msg = (String) msgQueue.poll();
                System.out.println("执行Queue中的msg :"+msg);
                Runnable task = new AccessDBThread(msg);
                threadPool.execute(task);
            }
        }
    };


    // 调度线程池
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);
    @SuppressWarnings("rawtypes")
    final ScheduledFuture taskHandler = scheduler.scheduleAtFixedRate(accessBufferThread, 0, 1, TimeUnit.SECONDS);



    private boolean hasMoreAcquire() {
        return !msgQueue.isEmpty();
    }

    private int getQueueLength() {
        return msgQueue.size();
    }

    public void addLogMsg(String msg) {
        Runnable task = new AccessDBThread(msg);
        threadPool.execute(task);
    }
}