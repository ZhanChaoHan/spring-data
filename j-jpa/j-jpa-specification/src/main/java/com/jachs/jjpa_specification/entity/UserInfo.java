package com.jachs.jjpa_specification.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/***
 * 用户详情表
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Table(name="user_info")
public class UserInfo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Integer id;//id
	 
	 @Column(name = "phoneNum",length = 11)
	 private Long phoneNum;//电话号码
	 
	 @Column(name = "register_time")
	 private Date registerTime;//注册时间
	 
	 @Column(name = "address")
	 private String Address;//住址

	 @OneToOne(cascade = CascadeType.ALL,targetEntity = User.class)
	 @JoinColumn(name="uId",referencedColumnName="userId",nullable=false)
	 private User uId;//用户id外键
}
