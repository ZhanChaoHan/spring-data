package com.jachs.database.jdbc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jachs.database.jdbc.entity.Torder;


/**
 * @author zhanchaohan
 */
@Repository
public class TorderDao {
    @Autowired
    @Qualifier("c3p0JdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    
    public int save(Torder torder) {
        String sql = "insert into t_order(o_id,u_id,o_name) values(?,?,?)";
       return jdbcTemplate.update(sql, torder.getO_id (),torder.getU_id (),torder.getO_name ());
    }
}
