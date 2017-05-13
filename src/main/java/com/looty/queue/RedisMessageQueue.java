/**
 * Copyright (c) www.bugull.com
 */
package com.looty.queue;

import com.looty.utils.StringUtil;
import org.apache.commons.lang3.SerializationUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.util.Pool;

import java.io.Serializable;

/**
 * USED TO:基于Redis实现的消息队列
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queue
 * @date 2017/5/9/009
 */
public class RedisMessageQueue<T extends Serializable> implements BaseMessageQueue<T> {

    private Long maxCapacity;

    private String key;

    private byte[] keyBytes;

    private Pool<ShardedJedis> shardedJedisPool;

    public RedisMessageQueue(String key, String keyBytes, Pool<ShardedJedis> shardedJedisPool) {
        this(DEFAULT_CAPACITY, key, shardedJedisPool);
    }

    public RedisMessageQueue(Long maxCapacity, String key, Pool<ShardedJedis> shardedJedisPool) {
        this.maxCapacity = maxCapacity;
        this.key = key;
        this.keyBytes = StringUtil.toUTF8Bytes(key);
        this.shardedJedisPool = shardedJedisPool;
    }

    @Override
    public boolean addFirst(T t) {
        ShardedJedis jedis = null;

        try {
            jedis = shardedJedisPool.getResource();

            Long size = jedis.llen(keyBytes);

            if (size < maxCapacity) {
                jedis.rpush(keyBytes, SerializationUtils.serialize(t));
                return true;
            }
            return false;

        } finally {

            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public T getFirst() {
        ShardedJedis jedis = null;

        try {

            jedis = shardedJedisPool.getResource();

            byte[] objBytes = jedis.rpop(keyBytes);

            if (objBytes != null) {
                return SerializationUtils.deserialize(objBytes);
            }
            return null;

        } finally {

            if (jedis != null) {
                jedis.close();
            }
        }
    }


    @Override
    public boolean addLast(T t) {

        ShardedJedis jedis = null;

        try {
            if (shardedJedisPool != null) {

                jedis = shardedJedisPool.getResource();
                Long size = jedis.llen(keyBytes);

                if (size < maxCapacity) {

                    jedis.lpush(keyBytes, SerializationUtils.serialize(t));
                    return true;
                }

            }
            return false;

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public T getLast() {
        ShardedJedis jedis = null;
        T t = null;

        try {

            if (shardedJedisPool != null) {

                jedis = shardedJedisPool.getResource();

                byte[] objBytes = jedis.lpop(keyBytes);
                t = SerializationUtils.deserialize(objBytes);

            }
            return t;

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean isFull() {
        ShardedJedis jedis = null;

        try {
            if (shardedJedisPool != null) {

                jedis = shardedJedisPool.getResource();
                Long size = jedis.llen(keyBytes);

                if (size == maxCapacity) {
                    return true;
                }
            }
            return false;

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        ShardedJedis jedis = null;

        try {
            if (shardedJedisPool != null) {

                jedis = shardedJedisPool.getResource();
                Long size = jedis.llen(keyBytes);

                if (size == 0) {
                    return true;
                }
            }
            return false;


        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Long getCapacity() {

        ShardedJedis jedis = null;
        Long size = null;

        try {
            if (shardedJedisPool != null) {

                jedis = shardedJedisPool.getResource();
                size = jedis.llen(keyBytes);
            }

            return size;

        } finally {

            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
