package com.jachs.jjpa_entity.otm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author zhanchaohan
 * 一对多的多
 */
@Data
@Entity
@Table(name="SoftWare")
public class SoftWare {
    @Id
    @Column(name = "softWareId")
    private String softWareId;
    
    @Column(name = "cId")
    private String cId;
    @Column(name = "softWareName")
    private String softWareName;
    
}
