package com.jachs.database.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import com.jachs.database.config.properties.C3p0Properties;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class DataBaseApplicationTest {
    @Autowired
    @Qualifier("c3p0Source")
    private DataSource c3ds;
    
    @Autowired
    @Qualifier("dbcpSource")
    private DataSource dbds;
    
    @Autowired
    @Qualifier("druidDataSource")
    private DataSource druidDataSource;
    
    @Autowired
    private C3p0Properties C3p0Properties;
    
    @Test
    public void bsTest() throws SQLException {
        System.out.println ( c3ds.getConnection ().isClosed () );
        System.out.println ( dbds.getConnection ().isClosed () );
        System.out.println ( druidDataSource.getConnection ().isClosed () );
    }
}
