package com.jachs.redis.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.jachs.redis.springbootredis.configure.StringRedisTemplateConfigure;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class StringRedisTemplateTest {
	@Autowired
    private StringRedisTemplate redisTemplate;
	@Autowired
	@Qualifier("srtc")
    private StringRedisTemplateConfigure srtc;
	
	@Test
	public void test1() {
		srtc.add("name", "kjc");
		
		System.out.println(srtc.get("name"));
	}
}
