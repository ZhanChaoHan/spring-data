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
@Table(name="Exam")
public class Exam {
    @Id
    private Integer examId;//考试ID
    @Column(name = "examName")
    private String examName;//考试名称
    @Column(name = "score")
    private Double score;//考试得分
    
    @ManyToMany
    @JoinTable
    private Set<Examinee>examinees;
    
}
