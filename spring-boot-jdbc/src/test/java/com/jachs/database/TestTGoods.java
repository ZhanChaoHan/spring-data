package com.jachs.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jdbc.dao.TgoodsDao;
import com.jachs.database.jdbc.entity.Tgoods;


/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest(classes = {SpringBootJdbcApplication.class})
public class TestTGoods {
    @Autowired
    private TgoodsDao tgoodsDao;
    
    @Test
    public void testSave() {
        tgoodsDao.save ( new Tgoods ( 1, "钢笔", "2" ) );
    }
}
