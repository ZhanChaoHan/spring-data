package com.jachs.database.jpa.otn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.otn.ComputerRepository;
import com.jachs.database.jpa.entity.otn.Computer;
import com.jachs.database.jpa.entity.otn.SoftWare;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class ComputerTest {
	@Autowired
	private ComputerRepository computerRepository;

	// 单条添加
	@Test
	public void testAdd() {
		Computer computer = new Computer();

		computer.setComputerId("C1");
		computer.setComputerName("微软");
		computer.setComputerPrice(123456L);
		computer.setMadeTime(new Date());

		computerRepository.save(computer);
	}

	// 多条添加
	@Test
	public void testAddMany() {
		Set<Computer> cList = new HashSet<>();

		Computer computer = new Computer();

		computer.setComputerId("C1");
		computer.setComputerName("微软");
		computer.setComputerPrice(123456L);
		computer.setMadeTime(new Date());
		cList.add(computer);

		Computer computer1 = new Computer();

		computer1.setComputerId("C2");
		computer1.setComputerName("联想");
		computer1.setComputerPrice(3456L);
		computer1.setMadeTime(new Date());
		cList.add(computer1);

		Computer computer2 = new Computer();

		computer2.setComputerId("C3");
		computer2.setComputerName("神州");
		computer2.setComputerPrice(79908L);
		computer2.setMadeTime(new Date());
		cList.add(computer2);

		computerRepository.saveAll(cList);
	}

	@Test
	public void testAddMultiple() {
		List<Computer> cList = new ArrayList<Computer>();

		String sId = "bid";
		String prefix = "打篮球";
		RandomStringUtils rsu = new RandomStringUtils();
		DateUtils du = new DateUtils();
		Date date = new Date();

		for (int nn = 0; nn < 50; nn++) {
			Computer computer = new Computer();

			computer.setComputerId(sId + nn);
			computer.setComputerName(prefix + rsu.randomAlphabetic(5));
			computer.setComputerPrice(new Long(nn));
			computer.setMadeTime(du.addDays(date, -nn));
			computer.setSoftWares(createSW(computer.getComputerId()));

			cList.add(computer);
		}
		computerRepository.saveAll(cList);
	}

	private Set<SoftWare> createSW(String cId) {
		Set<SoftWare> swSet = new HashSet<SoftWare>();
		RandomStringUtils rsu = new RandomStringUtils();
		for (int uu = 0; uu < 10; uu++) {
			SoftWare sw = new SoftWare();

			sw.setCId(rsu.random(255, "凿开混沌得乌金，藏蓄阳和意最深。爝火燃回春浩浩，洪炉照破夜沉沉。鼎彝元赖生成力，铁石犹存死后心。但愿苍生俱饱暖，不辞辛苦出山林。 "));
			sw.setSoftWareId(rsu.random(255, "共骇群龙水上游，不知原是木兰舟。云旗猎猎翻青汉，雷鼓嘈嘈殷碧流。屈子冤魂终古在，楚乡遗俗至今留。江亭暇日堪高会，醉讽离骚不解愁。 "));
			sw.setSoftWareName(rsu.random(255,
					"駉駉牡马，在坰之野。薄言駉者，有驈有皇，有骊有黄，以车彭彭。思无疆思，马斯臧。駉牡马，在坰之野。薄言駉者，有骓有駓，有骍有骐，以车伾伾。思无期思，马斯才。駉駉牡马，在坰之野。溥言駉者，有驒有骆，有骝有雒，以车绎绎。思无斁思，马斯作。駉駉牡马，在坰之野。薄言駉者，有骃有騢，有驔有鱼，以车祛祛。思无邪思，马斯徂。"));
			sw.setCId(cId);

			swSet.add(sw);
		}
		return swSet;
	}
}
