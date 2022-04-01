package com.jachs.jjpa_specification.predicate;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.dao.GoodsRepository;
import com.jachs.jjpa_specification.dao.OrderInfoRepository;
import com.jachs.jjpa_specification.dao.OrderRepository;
import com.jachs.jjpa_specification.dao.UserInfoRepository;
import com.jachs.jjpa_specification.dto.GoodsSimpleQueryDTO;
import com.jachs.jjpa_specification.dto.GoodsSimpleQueryDTO2;
import com.jachs.jjpa_specification.entity.Goods;
import com.jachs.jjpa_specification.utill.QueryHelp;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class PredicateTest {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private OrderRepository OrderRepository;
	
	@Test//单条件查询
	public void test1() {
		GoodsSimpleQueryDTO gsqDTO=new GoodsSimpleQueryDTO();
		
		gsqDTO.setGName("苹");
		
		List<Goods>  gList=goodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, gsqDTO, criteriaBuilder));
	
		gList.forEach(goods->{
			System.out.println(goods.toString());
		});
	}
	@Test//多条件查询
	public void test2() {
		GoodsSimpleQueryDTO2 gsqDTO=new GoodsSimpleQueryDTO2();
		
		gsqDTO.setGName("苹");
		gsqDTO.setGPrice(50);
		
		List<Goods>  gList=goodsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, gsqDTO, criteriaBuilder));
	
		gList.forEach(goods->{
			System.out.println(goods.toString());
		});
	}
}
