package com.jachs.jjpa_specification.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.entity.Order;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class OrderRepositoryTest {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test1() {
		Order order=new Order();
		
		order.setFinalState(0);
		order.setOrderId("test1");
		order.setUId(userRepository.findAll().get(0));
		order.setGoodsSet(goodsRepository.findAll());
		orderRepository.save(order);
	}
}
