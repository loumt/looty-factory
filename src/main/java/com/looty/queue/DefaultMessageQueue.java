/**
 * Copyright (c) www.bugull.com
 */
package com.looty.queue;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * USED TO:队列实现
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queue
 * @date 2017/5/9/009
 */
public class DefaultMessageQueue<T extends Serializable> implements BaseMessageQueue<T> {

    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 最大容量
     */
    private Long maxCapactiy;

    /**
     * 当前容量
     */
    private Long capacity;

    /**
     * 队列
     */
    private Deque<T> queue = new LinkedList<T>();

    @Override
    public boolean addFirst(T t) {
        lock.lock();

        try {

            if (capacity == maxCapactiy) {

                return false;
            }

            queue.addFirst(t);
            capacity++;
            return true;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addLast(T t) {

        lock.lock();
        try {
            if (capacity == maxCapactiy)
                return false;

            queue.addLast(t);
            capacity++;
            return true;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public T getFirst() {
        lock.lock();

        try {
            if (capacity == 0)
                return null;

            T t = queue.pollFirst();
            capacity--;
            return t;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public T getLast() {

        lock.lock();
        try {
            if (capacity == 0)
                return null;

            T t = queue.pollLast();
            capacity--;

            return t;


        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isFull() {

        lock.lock();

        try {
            if (capacity == maxCapactiy)
                return true;

            return false;

        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();

        try {
            if (capacity == 0) {
                return true;
            }
            return false;

        } finally {
            lock.unlock();
        }

    }

    @Override
    public Long getCapacity() {
        lock.lock();

        try {
            return capacity;

        } finally {
            lock.unlock();
        }
    }
}
