package com.yk.web.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
