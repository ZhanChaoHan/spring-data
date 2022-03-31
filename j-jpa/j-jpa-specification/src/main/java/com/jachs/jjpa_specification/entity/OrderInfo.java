package com.jachs.jjpa_specification.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Data;

/***
 * 订单表详情
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Proxy(lazy=false)
@Table(name="j_order_info")
public class OrderInfo {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "o_info_Id")
	 private Integer infoId;//id
	 
	 @Column(name = "num")
	 private Integer Num;//多少件
	 
	 @OneToOne(cascade = CascadeType.ALL,targetEntity = Order.class,fetch = FetchType.EAGER)
	 @JoinColumn(name="oID")
	 private Order order;//订单id
	 
	 @OneToOne(cascade = CascadeType.ALL,targetEntity = Goods.class,fetch = FetchType.EAGER)
	 @JoinColumn(name = "gID")
	 private Goods goods;//商品id
	 
}
