package com.jachs.jjpa_specification.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Data;

/***
 * 订单表
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Proxy(lazy=false)
@Table(name="j_order")
public class Order {
	 @Id
	 @Column(name = "orderId",length = 10)
	 private String orderId;//订单号
	 
	 @OneToOne(cascade = CascadeType.ALL,targetEntity = User.class)
	 @JoinColumn(name="cuId",referencedColumnName="userId",nullable=false)
	 private User uId;//用户id外键
	 
	 @Column(name = "finalState")
	 private int finalState;//最终状态:0下单,1放弃
}
