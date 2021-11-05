package com.jachs.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest(classes = {SpringBootJdbcApplication.class})
public class TestDataBase {
    @Autowired
    @Qualifier("dbcpSource")
    private DataSource dbcpDataSource;
    @Autowired
    @Qualifier("c3p0Source")
    private DataSource c3p0DataSource;
    @Autowired
    @Qualifier("druidDataSource")
    private DataSource druidDataSource;
    
    @Test
    public void tesT () throws SQLException {
        dbcpDataSource.getConnection ().createStatement ().execute ( "create table ts(test INT)" );
        c3p0DataSource.getConnection ().createStatement ().execute ( "create table ts(test INT)" );
        druidDataSource.getConnection ().createStatement ().execute ( "create table ts(test INT)" );
    }
}
