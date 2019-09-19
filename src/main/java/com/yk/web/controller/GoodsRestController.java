package com.yk.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.goods.Goods;
import com.yk.web.goods.GoodsServiceImpl;
import com.yk.web.order.OrderServiceImpl;


@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api-product")
@RestController
public class GoodsRestController {
	@Autowired
	GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@GetMapping(value="/goods/all", produces = "application/json; charset=UTF-8")
	public List<Goods> getGoodsList() {
		return goodsServiceImpl.getAllGoods();
	}
	
	
}
