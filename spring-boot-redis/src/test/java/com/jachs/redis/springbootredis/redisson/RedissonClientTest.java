package com.jachs.redis.springbootredis.redisson;

import org.junit.jupiter.api.Test;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/***
 * 分布式锁，分布式集合，可通过Redis支持延迟队列
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class RedissonClientTest {
	@Autowired
	private RedissonClient redissonClient;
	
	@Test
	public void test1() {
		redissonClient.getKeys().getKeys().forEach(key->{
			System.out.println(key);
		});
	}
	
}
