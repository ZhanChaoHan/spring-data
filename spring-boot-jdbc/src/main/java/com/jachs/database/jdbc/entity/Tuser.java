package com.jachs.database.jdbc.entity;


import java.util.Date;

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
public class Tuser {
    private int id;
    private String user_name;
    private String password;
    private Date last_login_time;
    private int sex;
    @Override
    public String toString () {
        return "Tuser [id=" + id + ", user_name=" + user_name + ", password=" + password + ", last_login_time="
                + last_login_time + ", sex=" + sex + "]";
    }
    
}
