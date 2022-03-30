package com.jachs.jjpa_specification.dao;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.entity.User;
import com.jachs.jjpa_specification.entity.UserInfo;

/**
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class UserInfoRepositoryTest {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	//初始化用户
	@Test
	public void test1() {
		User user=new User();
		
		user.setUserName("jack");
		user.setUserPwd("a1@de");
		
		UserInfo uInfo=new UserInfo();
		
		uInfo.setPhoneNum(12389767465L);
		uInfo.setRegisterTime(new Date());
		uInfo.setAddress("北京");
		uInfo.setUId(user);
		
		userInfoRepository.save(uInfo);
	}
}
