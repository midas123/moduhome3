package com.yk.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.dto.ApiResponseDto;
import com.yk.web.dto.OrderGoodsRequestDto;
import com.yk.web.goods.GoodsServiceImpl;
import com.yk.web.order.OrderServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api-order")
@RestController
public class OrderRestController {
	@Autowired
	GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/goods/order")
	public ResponseEntity<?> orderGoods(@RequestBody List<OrderGoodsRequestDto> dtoList) throws Exception{
		return ResponseEntity.ok(orderServiceImpl.orderGoods(dtoList));
		
	}
	
	@PutMapping("/goods/order/cancel")
	public ResponseEntity<?> cancleOrder(@RequestBody OrderGoodsRequestDto dto){
		orderServiceImpl.cancelOrder(dto);
		return ResponseEntity.ok(new ApiResponseDto(false,"주문 취소되었습니다."));
	}
}
