package com.jachs.jjpa_specification.dao;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.entity.Goods;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class GoodsRepositoryTest {
	@Autowired
	private GoodsRepository goodsRepository;
	
	String []goodsName=new String[] {"苹果","薯片","菠萝","老坛酸菜牛肉面","皮皮虾",
			"黄瓜","麻瓜","西瓜","牛肉","羊肉"};
	
	//初始化商品
	@Test
	public void test1() {
		Random radom=new Random();
		DateUtils du=new DateUtils();
		Date time=new Date();
		
		for (String name : goodsName) {
			Goods goods=new Goods();
			
			goods.setGName(name);
			goods.setGPrice(radom.nextInt(100));//0-64
			goods.setGuaranteeTime(du.addDays(time, radom.nextInt(100)));
			goods.setManufactureTime(du.addDays(time, radom.nextInt(100)));
			
			goodsRepository.save(goods);
		}
	}
}
