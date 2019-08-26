package com.yk.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.dto.ApiResponseDto;
import com.yk.web.dto.OrderGoodsRequestDto;
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
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/goods/all")
	public List<Goods> getGoodsList() {
		return goodsServiceImpl.getAllGoods();
	}
	
	@PostMapping("/goods/order")
	public ResponseEntity<?> orderGoods(@RequestBody OrderGoodsRequestDto dto){
		String message = orderServiceImpl.orderGoods(dto);
		return ResponseEntity.ok(new ApiResponseDto(false,message));
	}
	
	@PutMapping("/goods/order/cancel")
	public ResponseEntity<?> cancleOrder(@RequestBody OrderGoodsRequestDto dto){
		orderServiceImpl.cancelOrder(dto);
		return ResponseEntity.ok(new ApiResponseDto(false,"주문 취소되었습니다."));
	}
}
