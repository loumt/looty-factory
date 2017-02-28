/**
 * Copyright (c) www.bugull.com
 */
package redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
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
public class RedisTest {
    @Test
    public void redis1() {
        Jedis jedis = new Jedis("192.168.3.112", 6379);

        if (jedis != null) {
            System.out.println("Redis connection Success!");
        }
        jedis.set("testName", "loumt");
        System.out.println("Set Name Key:testName;Value:" + jedis.get("testName"));

        System.out.println(jedis.get("testName"));

        jedis.del("testName");
        System.out.println(jedis.get("testName"));

    }

}
