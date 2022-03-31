package com.jachs.jjpa_entity.mto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author zhanchaohan
 * 多对一的一
 */
@Data
@Entity
@Table(name="Player")
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pID")
    private Long playerId;
    
    @Column(name = "playerUserName")
    private String playerUserName;
    @Column(name = "level")
    private Integer level;
}
