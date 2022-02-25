package com.jachs.springbootr2db;

import com.jachs.springbootr2db.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***
 * @author zhanchaohan
 */
@SpringBootTest
public class R2dbcEntityTemplateTest {
    @Autowired
    private R2dbcEntityTemplate r2dbcEntityTemplate;

    //添加实体映射
    @Test
    public void test1(){
        User user=new User("ironMan","钢","铁侠");
        Mono<User> mono= r2dbcEntityTemplate.insert(user);

        mono.block();
    }
    //指定数据类型
    @Test
    public void test2(){
        r2dbcEntityTemplate.insert(User.class)
                .using(new User("皮皮","大","龙虾")).block();

    }
    //查询全部
    @Test
    public void test3(){
        Flux<User> flux=r2dbcEntityTemplate.select(User.class).all();
        flux.blockLast();
        flux.subscribe(a->{
                   System.out.println(a.getId()+"\t"+a.getFirstname()+"\t"+a.getLastname());
                });
    }
}
