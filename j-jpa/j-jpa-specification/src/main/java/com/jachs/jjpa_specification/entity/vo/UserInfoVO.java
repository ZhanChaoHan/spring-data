package com.jachs.jjpa_specification.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
	//user表字段
	private String userName;
	private String userPwd;
	//UserInfo表字段
	private Long phoneNum;
	private String Address;
	
	@Override
	public String toString() {
		return "UserInfoVO [userName=" + userName + ", userPwd=" + userPwd + ", phoneNum=" + phoneNum + ", Address="
				+ Address + "]";
	}
}
