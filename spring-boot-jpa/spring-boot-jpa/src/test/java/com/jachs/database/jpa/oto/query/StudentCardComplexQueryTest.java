package com.jachs.database.jpa.oto.query;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jachs.database.jpa.dao.oto.StudentCardRepository;
import com.jachs.database.jpa.entity.oto.StudentCard;

/***
 * 
 * @author zhanchaohan
 *@see https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#query-by-example
 */
@SpringBootTest
public class StudentCardComplexQueryTest {
	@Autowired
	private StudentCardRepository studentCardRepository;

	// 单字段查询
	@Test
	public void test() {
		StudentCard sc = studentCardRepository.findBycardName("机随称随");
		System.out.println(sc.getCardId());
	}

	// 多条件And
	@Test
	public void test1() {
		StudentCard sc = studentCardRepository.findByCardNameAndCardType("机随称随", "学生卡1");
		System.out.println(sc.getCardId());
	}

	@Test
	public void test2() {
		List<StudentCard> scList = studentCardRepository.findByCardType("学生卡1");

		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.getCardId());
		}
	}
	//匿名占位符
	@Test
	public void test5() {
		List<StudentCard> scList = studentCardRepository.findByCardNameOrCardType("机随称随", "学生卡1");
		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.getCardName()+"\t\t"+studentCard.getCardType());
		}
	}
	//排序
	@Test
	public void test3() {
		//默认升序
//		List<StudentCard> scList = studentCardRepository.findByAndSort("学生卡", Sort.by("cardId"));
//		for (StudentCard studentCard : scList) {
//			System.out.println(studentCard.getCardId());
//		}
		//改为降序
		List<StudentCard> scList = studentCardRepository.findByAndSort("学生卡", Sort.by("cardId").descending());
		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.getCardId());
		}
	}
	//分页
	@Test
	public void test6() {
		//参数1:页码，参数2：每页条数，参数3：排序字段以及排序方式
		Pageable pageable=PageRequest.of(1, 2, Sort.by("cardMonery"));
		Page<StudentCard> scList=studentCardRepository.findAll(pageable);
		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.getCardId()+"\t\t"+studentCard.getCardMonery());
		}
	}
	//条件分页
	@Test
	public void test7() {
		Pageable pageable=PageRequest.of(0, 2, Sort.by("cardMonery"));
		Page<StudentCard> scList=studentCardRepository.findByCardType("学生卡1",pageable);
		for (StudentCard studentCard : scList) {
			System.out.println(studentCard.getCardId()+"\t\t"+studentCard.getCardType()+"\t\t"+studentCard.getCardMonery());
		}
	}
}
