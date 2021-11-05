package com.jachs.database.jpa.oto.query;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.oto.StudentCardRepository;
import com.jachs.database.jpa.entity.oto.StudentCard;

/***
 * JpaRepository接口自带方法
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class StudentCardSimpleQueryTest {
	@Autowired
	private StudentCardRepository studentCardRepository;
	
	//查询全部条数
	@Test
	public void test1() {
		System.out.println(studentCardRepository.count());
	}
	//判断给定ID是否存在
	@Test
	public void test2() {
		System.out.println(studentCardRepository.existsById("cId0"));
	}
	//全查
	@Test
	public void test3() {
		List<StudentCard> csList=studentCardRepository.findAll();
		for (StudentCard studentCard : csList) {
			System.out.println(studentCard.getCardId());
		}
	}
}
