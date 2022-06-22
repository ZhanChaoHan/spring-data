package com.jachs.redis.springbootredis.lettuce;

import org.springframework.boot.test.context.SpringBootTest;

/***
 * lettuce采用netty连接redis server，实例可以在多个线程间共享，不存在线程不安全的情况，
 * 这样可以减少线程数量。当然，在特殊情况下，lettuce也可以使用多个实例。有点类似于NIO的模式。
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class LettuceTest {
		
}
