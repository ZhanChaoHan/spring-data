package com.jachs.database.jpa.transactional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.SpringBootJpaApplication;
import com.jachs.database.jpa.service.ComputerService;
import com.jachs.database.jpa.service.SoftWareService;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest(classes = SpringBootJpaApplication.class)
public class TransactionalTest {
	@Autowired
	private ComputerService computerSerice;
	@Autowired
	private SoftWareService softWareSerice;

	@Test
	public void test1() {
//		List<Computer> cList=computerSerice.findAll();
		
//		computerSerice.deleteById("bid0");
		computerSerice.deleteById("bid1","bid12","bidxx");
	}
}
