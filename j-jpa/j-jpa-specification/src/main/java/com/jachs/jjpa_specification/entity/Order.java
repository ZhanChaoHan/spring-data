package com.jachs.jjpa_specification.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/***
 * 订单表
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Table(name="order")
public class Order {
	 @Id
	 @Column(name = "orderId",length = 10)
	 private String orderId;//订单号
	 
	 @Column(name = "goodsSet")
	 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Goods.class)
	 @JoinColumn(name = "id")
	 private List<Goods>goodsSet;//商品单
	 
	 @OneToOne(cascade = CascadeType.ALL,targetEntity = User.class)
	 @JoinColumn(name="uId",referencedColumnName="userId",nullable=false)
	 private User uId;//用户id外键
	 
	 @Column(name = "finalState")
	 private int finalState;//最终状态:0下单,1放弃
}
