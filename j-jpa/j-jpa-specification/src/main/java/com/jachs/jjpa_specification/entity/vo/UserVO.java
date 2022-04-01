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
public class UserVO {
	//j_user表字段
	private String userName;
	//j_user_info表字段
	private Long phoneNum;
	private String address;
}
