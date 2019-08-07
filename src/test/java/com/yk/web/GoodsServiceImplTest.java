package com.yk.web;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yk.web.goods.Goods;
import com.yk.web.goods.GoodsRepository;

@RunWith(SpringRunner.class) 
@SpringBootTest //어플리케이션 전체(디폴트)
//@SpringBootTest(classes ={GoodsServiceImpl.class}) //Application context를 GoodsServiceImpl 클래스로 제한
public class GoodsServiceImplTest {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Test
	public void test() {
		List<Goods> goods = goodsRepository.findAll();
		System.out.println(goods.size());
		assertTrue(goods.size()>0);
	}
	
}
