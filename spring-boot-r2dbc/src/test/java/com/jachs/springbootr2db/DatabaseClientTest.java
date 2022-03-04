package com.jachs.springbootr2db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.Map;

/***
 * @author zhanchaohan
 */
@SpringBootTest
public class DatabaseClientTest {
    @Autowired
    DatabaseClient databaseClient;

    //不好使
    @Test
    public void add1(){
       Flux<Map<String,Object>>fl= databaseClient.sql("INSERT INTO users (id, firstname, lastname) VALUES(a, b, c)")

                .bind("a","亿")
                .bind("b","卡骆驰")
                .bind("c","联名卡")
                .fetch().all();
        fl.blockLast();
    }
    @Test
    public void query1(){
        Flux<Map<String, Object>> rows = databaseClient
                .sql("SELECT id, firstname, lastname FROM users")
                .fetch()
                .all();

        rows.blockLast();
        rows.subscribe(a->{
            a.keySet().forEach(key->{
               Object values= a.get(key);
               System.out.println(key+"\t"+values);
            });
        });
    }
}
