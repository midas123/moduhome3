package com.yk.web.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
