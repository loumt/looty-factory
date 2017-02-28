/**
 * Copyright (c) www.bugull.com
 */
package redis;

import org.apache.commons.codec.language.Soundex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package redis
 * @date 2017/2/28/028
 */
public class RedisConfigTest {

    private Jedis jedis;
    private JedisPool jedisPool;

    private static final String HOST_NAME = "192.168.3.211";
    private static final Integer PORT = 6379;

    @Before
    public void setRedisConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //默认
//        public int maxIdle = 8;
//        public int minIdle = 0;
//        public int maxActive = 8;
//        public long maxWait = -1L;
        jedisPoolConfig.setMaxActive(8);//最大
        jedisPoolConfig.setMaxIdle(4);//最小空闲
        jedisPoolConfig.setMaxWait(8000);//最大等待时间

        jedisPool = new JedisPool(jedisPoolConfig, HOST_NAME, PORT);
        jedis = jedisPool.getResource();
        if (jedis != null) {
            System.out.println("Redis Connection Success!");
        }
    }


    @Test
    public void getParam() {

    }

    @After
    public void returnRedisConn() {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

}
