/*
 * Copyright (c) www.bugull.com
 */

package com.looty.redis.recipes;


import com.looty.redis.RedisConnection;
import com.looty.redis.exception.RedisException;
import com.looty.redis.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Frank Wen(xbwen@hotmail.com)
 */
public abstract class AbstractStringRecipe extends BaseRecipe {

    public String get(String key) throws RedisException {
        byte[] bytes = get(key.getBytes());
        if (bytes == null) {
            return null;
        } else {
            return new String(bytes);
        }
    }

    public byte[] get(byte[] key) throws RedisException {
        byte[] result = null;
        JedisPool pool = RedisConnection.getInstance().getPool();
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            result = jedis.get(key);
        } catch (Exception ex) {
            throw new RedisException(ex.getMessage(), ex);
        } finally {
            JedisUtil.returnToPool(pool, jedis);
        }
        return result;
    }

}
