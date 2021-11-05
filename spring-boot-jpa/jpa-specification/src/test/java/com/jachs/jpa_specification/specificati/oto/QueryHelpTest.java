package com.jachs.jpa_specification.specificati.oto;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jpa_specification.JpaSpecificationApplication;
import com.jachs.jpa_specification.dao.PersonRepository;
import com.jachs.jpa_specification.dto.oto.PersonDto;
import com.jachs.jpa_specification.entity.oto.Person;
import com.jachs.jpa_specification.mapper.PersonMapper;
import com.jachs.jpa_specification.utill.QueryHelp;
import com.jachs.jpa_specification.vo.oto.PersonVo;


/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest(classes = JpaSpecificationApplication.class)
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
