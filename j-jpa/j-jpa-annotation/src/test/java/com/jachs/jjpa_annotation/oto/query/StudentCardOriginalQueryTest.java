package com.jachs.jjpa_annotation.oto.query;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.oto.StudentCardRepository;
import com.jachs.jjpa_entity.oto.StudentCard;

/***
 * 原生SQL查询
 * @author zhanchaohan
 * @see https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#query-by-example
 */
@SpringBootTest
public class StudentCardOriginalQueryTest {
	@Autowired
	private StudentCardRepository studentCardRepository;

	@Test
	public void test() {
		List<StudentCard> scList = studentCardRepository.findByCardTypeAndSort("学生卡1");
		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.toString());
		}
	}
}
