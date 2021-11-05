package com.jachs.database;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jdbc.dao.TorderDao;
import com.jachs.database.jdbc.entity.Torder;


/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest(classes = {SpringBootJdbcApplication.class})
public class TestTOrder {
    @Autowired
    private TorderDao torderDao;
    
    @Test
    public void testO() {
        torderDao.save ( new Torder ( 1, 1,"订单1" ) );
    }
}
