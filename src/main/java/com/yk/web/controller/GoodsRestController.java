package com.yk.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.goods.Goods;
import com.yk.web.goods.GoodsServiceImpl;


@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api")
@RestController
public class GoodsRestController {
	@Autowired
	GoodsServiceImpl goodsServiceImpl;
	
	@GetMapping("/")
	public String main() {
		
		return "main";
	}
	
	@GetMapping("/goods/all")
	public List<Goods> getGoodsList() {
		return goodsServiceImpl.getAllGoods();
	}
}
