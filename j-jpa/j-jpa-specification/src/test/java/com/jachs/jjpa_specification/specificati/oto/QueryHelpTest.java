package com.jachs.jjpa_specification.specificati.oto;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dao.PersonRepository;
import dto.oto.PersonDto;
import entity.oto.Person;
import mapper.PersonMapper;
import utill.QueryHelp;
import vo.oto.PersonVo;



/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class QueryHelpTest {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonMapper personMapper;
	
	private void print(List<Person>pList) {
		for (Person person : pList) {
			System.out.println(person.getPId()+"\t\t"+person.getNickName());
		}
	}
	//对象查询
	@Test
	public void tec() {
		PersonDto pd=new PersonDto();
		pd.setNickName("四十二");
//		pd.setEmail("@qq");
		
		List<Person>pList=personRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, pd, criteriaBuilder));
		print(pList);
	}
	//连表
	@Test
	public void mkc() {
		PersonDto pd=new PersonDto();
		pd.setCid(6);
		
		List<Person>pList=personRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, pd, criteriaBuilder));
		List<PersonVo> pvList=personMapper.toDto(pList);
		
		for (PersonVo personVo : pvList) {
			System.out.println(personVo.toString());
		}
	}
}
