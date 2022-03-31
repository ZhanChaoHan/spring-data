package com.jachs.jjpa_annotation.transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.otm.ComputerRepository;
import com.jachs.jjpa_annotation.dao.otm.SoftWareRepository;


/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class TransactionalTest {
	@Autowired
	private ComputerRepository computerSerice;
	@Autowired
	private SoftWareRepository softWareSerice;

	@Test
	public void test1() {
	}
}
