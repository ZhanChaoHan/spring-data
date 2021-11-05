package com.jachs.database.jpa.entity.nto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

/**
 * @author zhanchaohan
 * 多对一的多
 */
@Data
@Entity
@Table(name="VideoGame")
public class VideoGame {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long gameId;
    
    @Column(name = "gameName")
    private String gameName;
    @Column(name = "gamePrice")
    private Integer gamePrice;
    
    @ManyToOne(targetEntity = Player.class,optional = true)
    private Player player;
}
