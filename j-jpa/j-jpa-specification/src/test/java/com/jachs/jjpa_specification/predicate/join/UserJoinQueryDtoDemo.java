package com.jachs.jjpa_specification.predicate.join;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.dao.UserRepository;
import com.jachs.jjpa_specification.entity.vo.UserVO;
import com.jachs.jjpa_specification.utill.BeanUtils;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class UserJoinQueryDtoDemo {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test1() throws IllegalAccessException, InstantiationException {
		List<Map<String, Object>> mMap=userRepository.findUserVOByUserId(1);
		
		List<UserVO> uVlist=BeanUtils.toList(mMap, UserVO.class);
		
		uVlist.forEach(a->{
			System.out.println(a.toString());
		});
	}
}
