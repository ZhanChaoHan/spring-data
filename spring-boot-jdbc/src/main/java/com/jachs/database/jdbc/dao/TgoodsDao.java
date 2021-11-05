package com.jachs.database.jdbc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jachs.database.jdbc.entity.Tgoods;


/**
 * @author zhanchaohan
 */
@Repository
public class TgoodsDao {
    @Autowired
    @Qualifier("dbcpJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    public int save(Tgoods tgoods) {
        String sql = "insert into t_goods(g_id,g_name,g_monery) values(?,?,?)";
       return jdbcTemplate.update(sql, tgoods.getG_id (),tgoods.getG_name (),tgoods.getG_monery ());
    }
}
