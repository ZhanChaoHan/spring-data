package com.jachs.springbootr2db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;

/***
 * @author zhanchaohan
 */
@SpringBootTest
public class DatabaseClientTest {
    @Autowired
    DatabaseClient databaseClient;

    @Test
    public void test1(){
        /*
        databaseClient.insert()
                .into("person")
                .value("id", "123")
                .value("name", "wujiuye")
                .nullValue("age", Integer.class)
                .fetch()
                .rowsUpdated()
                .subscribe(System.out::println);
                */

    }
}
