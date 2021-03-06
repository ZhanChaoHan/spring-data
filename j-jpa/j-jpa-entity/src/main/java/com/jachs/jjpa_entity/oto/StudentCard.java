package com.jachs.jjpa_entity.oto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author zhanchaohan
 * 学生卡对象被关联对象
 */
@Data
@Entity
@Table(name="StudentCard")
public class StudentCard {
    @Id
    @Column(name = "cardId")
    private String cardId;
    
    @Column(name = "cardType")
    private String cardType;
    
    @Column(name = "cardMonery")
    private Long cardMonery;
    
    @Column(name = "cardName",length = 20)
    private String cardName;

	@Override
	public String toString() {
		return "StudentCard [cardId=" + cardId + ", cardType=" + cardType + ", cardMonery=" + cardMonery + ", cardName="
				+ cardName + "]";
	}
}
