package com.jachs.jjpa_specification.predicate.join;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.dao.UserInfoRepository;
import com.jachs.jjpa_specification.dto.join.UserJoinQueryDTO;
import com.jachs.jjpa_specification.entity.UserInfo;
import com.jachs.jjpa_specification.mapper.UserInfoMapper;
import com.jachs.jjpa_specification.utill.QueryHelp;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class UserInfoJoinQueryDtoDemo {
	@Autowired
	private UserInfoRepository userRepository;
	@Autowired
	private UserInfoMapper userMapper;
	
	@Test
	public void test1() {
		UserJoinQueryDTO uQ=new UserJoinQueryDTO();
		
		uQ.setAddress("北京");
		
		List<UserInfo>  userList=userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, uQ, criteriaBuilder));
		
		userList.forEach(uInfo->{
			System.out.println(uInfo.toString());
		});
		userMapper.toDto(userList).forEach(VO->{//转换个VO取必要字段
			System.out.println(VO.toString());
		});
		
	}
}
