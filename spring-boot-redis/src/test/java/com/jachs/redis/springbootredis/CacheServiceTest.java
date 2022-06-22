package com.jachs.redis.springbootredis;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.redis.springbootredis.configure.CacheServiceConfigure;
import com.jachs.redis.springbootredis.entity.User;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class CacheServiceTest {
	@Autowired
	private CacheServiceConfigure cacheService;
	
	@Test
	public void test1() {
		cacheService.add("test", 1234);
		
		System.out.println(cacheService.get("test"));
	}
	//将对象转换成jsonString并存入redis
	@Test
	public void test2() {
		 User user = new User(12, "jhcs", 20);
		 
	     cacheService.add(user.getId(), user);
	     
	     System.out.println(cacheService.getObject(user.getId(), User.class).toString());
	}
	//将对象集合转换成jsonString，并设置过期时间存入至redis
	@Test
	public void test3() {
		ArrayList<User> users = new ArrayList<>();
        User user = new User(66, "jachs", 666);
        User user1 = new User(111, "张三", 222);
        
        users.add(user);
        users.add(user1);
        cacheService.add("key", users, 2, TimeUnit.HOURS);
        
        System.out.println(cacheService.getList("key", User.class));
	}
	//获取 hash-setvalue
	@Test
	public void test5() {
		cacheService.addHashCache("hashKey", "key", "value");
		
		System.out.println(cacheService.getHashCache("hashKey", "key"));
	}
}
