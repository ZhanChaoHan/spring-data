package com.jachs.database.jpa.oto.add;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.SpringBootJpaApplication;
import com.jachs.database.jpa.dao.oto.StudentCardRepository;
import com.jachs.database.jpa.entity.oto.StudentCard;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest(classes = SpringBootJpaApplication.class)
public class StudentCardTest {
	@Autowired
	private StudentCardRepository studentCardRepository;

	@Test
	public void testAddOne() {
		StudentCard sc = new StudentCard();
		sc.setCardId("cId");
		sc.setCardMonery(598475L);
		sc.setCardType("学生卡");
		sc.setCardName("CAZNAME");
		studentCardRepository.save(sc);
	}

	@Test
	public void testAddLoop() {
		Random random = new Random();
		RandomStringUtils rsu=new RandomStringUtils();
		int type=0;
		for (int kk = 0; kk < 100; kk++) {
			StudentCard sc = new StudentCard();
			sc.setCardId("cId" + kk);
			sc.setCardMonery(random.nextLong() * 500);
			if(kk%10==0) {
				type++;
			}
			sc.setCardType("学生卡" + type);
			sc.setCardName(rsu.random ( 4, "卡名称随机字符串"));
			studentCardRepository.save(sc);
		}
	}
}
