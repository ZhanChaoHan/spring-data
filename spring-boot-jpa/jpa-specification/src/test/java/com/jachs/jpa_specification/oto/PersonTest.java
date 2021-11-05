package com.jachs.jpa_specification.oto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jpa_specification.dao.PersonRepository;
import com.jachs.jpa_specification.entity.oto.IdCard;
import com.jachs.jpa_specification.entity.oto.Person;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class PersonTest {
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void test1() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		RandomStringUtils rsu=new RandomStringUtils();
		RandomUtils ru=new RandomUtils();
		
		List<Person>pList=new ArrayList<Person>();
		for (int kk = 0; kk < 50; kk++) {
			IdCard ic=new IdCard();
			ic.setAddress(rsu.random(10, "后赌哎浩本期超v开年我王企鹅承保v"));
			ic.setAge(kk);
			ic.setName(rsu.random(3, "王李孙赵钱搜句"));
			ic.setBirthDay(sdf.parse(ru.nextLong(1000, 3000)+"-"+ru.nextInt(1,12)+"-"+ru.nextInt(1,28)));
			
			Person pe=new Person();
			pe.setEmail("hcngvu@qq.com");
			pe.setNickName(rsu.random(3, "一二三四五六七八九十"));
			pe.setPCard(ic);
			
			pList.add(pe);
		}
		personRepository.saveAll(pList);
	}
}
