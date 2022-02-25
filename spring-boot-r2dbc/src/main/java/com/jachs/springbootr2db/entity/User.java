package com.jachs.springbootr2db.entity;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/***
 * @author zhanchaohan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class User {
    @Id
    @Column("id")
    private String id;
    @Column("firstname")
    private String firstname;
    @Column("lastname")
    private String lastname;
    
}
