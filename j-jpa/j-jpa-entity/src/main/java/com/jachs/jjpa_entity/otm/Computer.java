package com.jachs.jjpa_entity.otm;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author zhanchaohan
 * 一对多的一
 */
@Data
@Entity
@Table(name="Computer")
public class Computer {
    @Id
    private String computerId;
    
    @Column(name = "computerName")
    private String computerName;
    
    @Column(name = "madeTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date madeTime;
    
    @Column(name = "computerPrice")
    private Long computerPrice;
    
    @OneToMany(targetEntity = SoftWare.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "cFKId" )
    private Set<SoftWare> softWares;
}
