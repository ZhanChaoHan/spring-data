package com.jachs.jjpa_annotation.specificati;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jachs.jjpa_annotation.dao.otn.ComputerRepository;
import com.jachs.jjpa_annotation.dao.otn.SoftWareRepository;
import com.jachs.jjpa_annotation.dto.ComputerDto;
import com.jachs.jjpa_annotation.utill.QueryHelp;
import com.jachs.jjpa_entity.otn.Computer;
import com.jachs.jjpa_entity.otn.SoftWare;


/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class QueryHelpDemo {
	@Autowired
	private ComputerRepository computerRepository;
	@Autowired
	private SoftWareRepository softWareRepository;

	//like查询
	@Test
	public void test() {
		ComputerDto cd = new ComputerDto();

		cd.setComputerName("皮皮虾");
		List<Computer> systemUserList = computerRepository
				.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, cd, criteriaBuilder));

		for (Computer computer : systemUserList) {
			System.out.println(computer.getComputerId() + "\t" + computer.getComputerName());
		}
	}
	//排序，分页
	@Test
	public void test1() {
		ComputerDto cd = new ComputerDto();

		cd.setComputerName("皮皮虾");
		
		Pageable pageable=PageRequest.of(1, 2, Sort.by("computerPrice"));
		
		Page<Computer>cPage=computerRepository
				.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, cd, criteriaBuilder),pageable);

		for (Computer computer : cPage) {
			System.out.println(computer.getComputerId() + "\t" + computer.getComputerName());
		}
	}
	//like ,between
	@Test
	public void test2() {
		List<String>dList=new ArrayList<String>();
		
		dList.add("2021-07-12 09:58:55");
		dList.add("2021-07-14 09:58:55");
		
		ComputerDto cd = new ComputerDto();
		cd.setComputerName("皮皮虾");
		cd.setMadeTime(dList);
		
		List<Computer> systemUserList = computerRepository
				.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, cd, criteriaBuilder));

		for (Computer computer : systemUserList) {
			Set<SoftWare>sw=computer.getSoftWares();
			
			System.out.println(computer.getComputerId() + "\t" + computer.getComputerName());
			
			for (SoftWare sws : sw) {
				System.out.println(sws.getCId());
			}
		}
	}
	@Test
	public void test3() {
		ComputerDto cd = new ComputerDto();
		
		cd.setCId("aid18");
		
		List<Computer> systemUserList = computerRepository
				.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, cd, criteriaBuilder));

		for (Computer computer : systemUserList) {
			System.out.println(computer.getComputerId() + "\t" + computer.getComputerName());
		}
	}
	
}
