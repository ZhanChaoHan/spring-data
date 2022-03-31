package com.jachs.jjpa_specification.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Data;

/***
 * 用户表
 * @author zhanchaohan
 *
 */
@Data
@Entity
@Proxy(lazy=false)
@Table(name="j_user")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "userId")
	 private Integer userId;//id
	 
	 @Column(name = "userName")
	 private String userName;//用户名
	 
	 @Column(name = "userPwd")
	 private String userPwd;//密码

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
}
