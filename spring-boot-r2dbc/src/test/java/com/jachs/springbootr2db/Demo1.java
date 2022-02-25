package com.jachs.springbootr2db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.springbootr2db.dao.UserRepository;
import com.jachs.springbootr2db.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/***
 * @author zhanchaohan
 */
@SpringBootTest
public class Demo1 {
    @Autowired
    private UserRepository userRepository;

    //查询全部
    @Test
    public void queryAll(){
      Flux<User> userList=  userRepository.findAll();
        userList.blockLast();
        userList.subscribe(a->{
            System.out.println(a.getFirstname()+"\t"+a.getLastname());
        });
    }

    /***
     * 实体映射对象貌似不好使
     * @see R2dbcEntityTemplateTest.test1()
     */
    @Test
    public void add(){
        User user=new User("Id","mike","jasonl");

        Mono<User>mono=userRepository.save(user);
        
        User rUser=mono.block();
        
        System.out.println(rUser.getFirstname()+"\t"+rUser.getLastname());
    }

    @Test
    public void add1(){
        Mono<Integer> monoUser=userRepository.addUser("棒棒糖","阿尔卑斯","斯卑尔阿");

        monoUser.block();
        monoUser.doFinally((a)->{
            System.out.println("执行完毕");
        });
    }
}
