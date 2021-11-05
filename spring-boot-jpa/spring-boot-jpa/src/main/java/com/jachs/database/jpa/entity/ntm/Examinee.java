package com.jachs.database.jpa.entity.ntm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;

/**
 * @author zhanchaohan
 * 
 */
@Data
@Entity
@Table(name="Examinee")
public class Examinee {
    @Id
    private Integer examineeId;//考生ID
    @Column(name = "examineeName")
    private String examineeName;//考生名字
    
    @ManyToMany
    @JoinTable
    private Set<Exam>exams;
}
