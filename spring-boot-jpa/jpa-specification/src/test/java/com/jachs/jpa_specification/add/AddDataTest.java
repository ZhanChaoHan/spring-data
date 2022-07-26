package com.jachs.jpa_specification.add;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;
import com.jachs.jpa_specification.dao.PersonRepository;
import com.jachs.jpa_specification.entity.oto.IdCard;
import com.jachs.jpa_specification.entity.oto.Person;

/**
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class AddDataTest {
	private static Faker FAKER = new Faker(Locale.CHINA);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void adds() {
		for (int kk = 1; kk < 10; kk++) {
			Person per=new Person();
			
			per.setEmail(FAKER.app().author());
			per.setNickName(FAKER.ancient().primordial());
			per.setPId(new Long(kk));
			
			IdCard card=new IdCard();
			
			card.setAddress(FAKER.address().city());
			card.setAge(kk);
			card.setBirthDay(FAKER.date().birthday());
			card.setName(FAKER.animal().name());
			card.setCId(new Long(kk));
			
			per.setPCard(card);
			personRepository.save(per);
		}
	}
}
