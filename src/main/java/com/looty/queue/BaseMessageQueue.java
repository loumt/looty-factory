package com.looty.queue;

import java.io.Serializable;

/**
 * USED TO:基础队列消息类
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queue
 * @date 2017/5/9/009
 */
public interface BaseMessageQueue<T extends Serializable> {

    /**
     * 默认容量
     */
    public static final Long DEFAULT_CAPACITY = 10000L;

    /**
     * 往队列之前添加一个元素
     *
     * @param t
     * @return
     */
    boolean addFirst(T t);

    /**
     * 往队列后添加一个元素
     *
     * @param t
     * @return
     */
    boolean addLast(T t);

    /**
     * 获取第一个元素
     *
     * @param t
     * @return
     */
    T getFirst();

    /**
     * 获取最后一个元素
     *
     * @param t
     * @return
     */
    T getLast();

    /**
     * 是否已满
     *
     * @return
     */
    boolean isFull();

    /**
     * 是否为空队列
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取容量
     *
     * @return
     */
    Long getCapacity();
}
