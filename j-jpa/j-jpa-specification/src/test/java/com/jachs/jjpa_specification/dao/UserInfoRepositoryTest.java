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
		
		User user1=new User();
		
		user1.setUserName("alien");
		user1.setUserPwd("jchab@qq.com");
		
		UserInfo uInfo1=new UserInfo();
		
		uInfo1.setPhoneNum(22389767465L);
		uInfo1.setRegisterTime(new Date());
		uInfo1.setAddress("天津");
		uInfo1.setUId(user1);
		
		userInfoRepository.save(uInfo1);
		
		User user2=new User();
		
		user2.setUserName("AK47");
		user2.setUserPwd("TUTUTUUT@qq.com");
		
		UserInfo uInfo2=new UserInfo();
		
		uInfo2.setPhoneNum(22389767465L);
		uInfo2.setRegisterTime(new Date());
		uInfo2.setAddress("北京");
		uInfo2.setUId(user2);
		
		userInfoRepository.save(uInfo2);
	}
}
