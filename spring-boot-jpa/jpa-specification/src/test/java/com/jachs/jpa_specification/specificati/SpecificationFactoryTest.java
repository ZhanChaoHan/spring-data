package com.jachs.jpa_specification.specificati;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.jachs.jpa_specification.dao.PersonRepository;
import com.jachs.jpa_specification.entity.oto.Person;
import com.jachs.jpa_specification.utill.SpecificationFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class SpecificationFactoryTest {
	@Autowired
	private PersonRepository personRepository;

	@Test
	public void test1() {
		// 构造条件
		Specification specification = SpecificationFactory.eq("NickName", "四十二");
		// 打印结果
		List<Person> systemUserList = personRepository.findAll(specification);

		for (Person user : systemUserList) {
			System.out.println(user);
		}
	}

	@Test
	public void test2() {
		Specification specification = SpecificationFactory.eq("Email", "hcngvu@qq.com");
		specification = SpecificationFactory.eq("NickName", "四十二");
		List<Person> systemUserList = personRepository.findAll(specification);

		for (Person user : systemUserList) {
			System.out.println(user);
		}
	}
}
