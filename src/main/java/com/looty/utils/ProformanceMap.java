/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁：
 * ReadWriteLock
 * 适用于读多写少
 * 写锁中可获取读锁，读锁中不能获取写锁
 * 非公平锁（默认）适合更大的吞吐量
 */
public class ProformanceMap {
    private final Map<String, Object> m = new TreeMap<String, Object>();

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(false);

    private final Lock r = rwl.readLock();

    private final Lock w = rwl.writeLock();

    public Object get(String key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }

    }

    public Object put(String key, Object o) {
        w.lock();
        try {
            return m.put(key, o);
        } finally {
            w.unlock();
        }
    }

    public Object[] allKeys() {
        r.lock();
        try {
            return m.keySet().toArray();
        } finally {
            r.unlock();
        }
    }

    public void clear() {
        w.lock();
        try {
            m.clear();
        } finally {
            w.unlock();
        }
    }

}
