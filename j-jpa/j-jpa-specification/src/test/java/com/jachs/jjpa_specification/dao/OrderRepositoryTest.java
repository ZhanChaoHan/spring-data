package com.jachs.jjpa_specification.dao;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_specification.entity.Goods;
import com.jachs.jjpa_specification.entity.Order;
import com.jachs.jjpa_specification.entity.OrderInfo;

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
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	
	
	Random radom=new Random();
	
	@Test
	public void test1() {
		Order order=new Order();
		
		order.setFinalState(0);//成功订单
		order.setOrderId("test1");
		order.setUId(userRepository.findAll().get(0));
		orderRepository.save(order);
		
		Order order1=new Order();
		
		order1.setFinalState(1);//失败订单
		order1.setOrderId("test2");
		order1.setUId(userRepository.findAll().get(0));
		orderRepository.save(order1);
	}
	int infoId=1;
	private void initOrderInfo(Goods goods,Order order) {
		OrderInfo oInfo=new OrderInfo();
		
		oInfo.setGoods(goods);
		oInfo.setInfoId(infoId);
		oInfo.setNum(radom.nextInt(100));
		oInfo.setOrder(order);
		
		orderInfoRepository.save(oInfo);
		infoId++;
	}
	//初始化订单详情
	@Test
	public void test2() {
		for (int kk = 1; kk < 10; kk++) {
			Goods goods=goodsRepository.getById(kk);
			System.out.println(goods.toString());
			initOrderInfo(goods,orderRepository.findAll().get(0));
		}
		for (int kk = 1; kk < 10; kk++) {
			initOrderInfo(goodsRepository.getById(kk),orderRepository.findAll().get(1));
		}
	}
}
