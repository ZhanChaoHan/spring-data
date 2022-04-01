package com.jachs.jjpa_specification.specification;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.jachs.jjpa_specification.dao.GoodsRepository;
import com.jachs.jjpa_specification.dao.OrderInfoRepository;
import com.jachs.jjpa_specification.dao.UserInfoRepository;
import com.jachs.jjpa_specification.entity.Goods;
import com.jachs.jjpa_specification.utill.SpecificationFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class SpecificationFactoryDemo {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private GoodsRepository goodsRepository;
	
	//单条件查询
	@Test
	public void test1() {
		Specification specification = SpecificationFactory.eq("gName", "苹果");
		
		List<Goods> gList=goodsRepository.findAll(specification);
		
		gList.forEach(goods->{
			System.out.println(goods.toString());
		});
	}
	
	//多条件查询
	@Test
	public void test2() {
		Specification specification = SpecificationFactory.likeStart("gName", "苹");
		
		specification.and(SpecificationFactory.lt("gPrice", 12));
		
		List<Goods> gList=goodsRepository.findAll(specification);
		
		gList.forEach(goods->{
			System.out.println(goods.toString());
		});
	}
	
}
