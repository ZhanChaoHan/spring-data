package com.jachs.database;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jdbc.dao.TuserDao;
import com.jachs.database.jdbc.entity.Tuser;


/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest(classes = {SpringBootJdbcApplication.class})
public class TestTUser {
    @Autowired
    private TuserDao tuserDao;
    
    @Test
    public void testU() {
        for ( Tuser user : tuserDao.queryAll () ) {
            System.out.println ( user.toString () );
        }
    }
    @Test
    public void testA() {
        Tuser user=new Tuser();
        user.setId ( 71 );
        user.setLast_login_time ( new Date() );
        user.setPassword ( "1578" );
        user.setSex ( 0 );
        user.setUser_name ( "mbg" );
        tuserDao.saveM( user );
    }
}
