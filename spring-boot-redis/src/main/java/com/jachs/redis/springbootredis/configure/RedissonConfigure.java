package com.jachs.redis.springbootredis.configure;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 
 * @author zhanchaohan
 *
 */
@Configuration
public class RedissonConfigure {
    @Bean
    public RedissonClient redisson() throws IOException {
        Config config = Config.fromYAML(
            RedissonConfigure.class.getClassLoader().getResource("redisson-config.yaml"));
        return Redisson.create(config);
    }

}
