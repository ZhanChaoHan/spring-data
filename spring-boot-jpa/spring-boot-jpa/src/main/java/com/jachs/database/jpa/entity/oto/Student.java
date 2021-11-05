package com.jachs.database.jpa.entity.oto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * OneToOne单项关联一个学生一个卡
 * @author zhanchaohan
 * 
 */
@Data
@Entity
@Table(name="Student")
public class Student {
    @Id
    private String studentId;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "studentAge")
    private int studentAge;
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sCart")
    private StudentCard studentCard;
}
