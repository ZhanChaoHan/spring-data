package com.jachs.jjpa_specification.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/***
 * 商品表
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Table(name="goods")
public class Goods {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer id;//id
	 
	 @Column(name = "gName",length = 10)
	 private String gName;//商品名称
	 
	 @Column(name = "gPrice")
	 private double gPrice;//商品价格
	 
	 @Column(name = "manufactureTime")
	 private Date manufactureTime;//生产日期
	 
	 @Column(name = "guaranteeTime")
	 private Date guaranteeTime;//保质期
	 
}
