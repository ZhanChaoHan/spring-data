package com.jachs.database.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanchaohan
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Torder {
    private int o_id;
    private int u_id;
    private String o_name;
    
}
