package com.yk.web.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.web.dto.OrderGoodsRequestDto;
import com.yk.web.dto.orderResponseDto;
import com.yk.web.goods.Goods;
import com.yk.web.goods.GoodsDetail;
import com.yk.web.goods.GoodsDetailRepository;
import com.yk.web.goods.GoodsRepository;
import com.yk.web.users.Users;

@Service
public class OrderServiceImpl {
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private GoodsDetailRepository goodsDetailRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	public orderResponseDto orderGoods(List<OrderGoodsRequestDto> dtoList) throws Exception {
		System.out.println("orderGoods: "+dtoList.toString());
		
		String ordercode = makeOrderCode();
		for(OrderGoodsRequestDto dto: dtoList) {
		
			boolean isStocked = isProductStocked(dto);
		
			if(isStocked) {
				System.out.println("make order");
				Orders order = dto.toOrderEntity();
				
				order.setOrderCode(ordercode);
				order.setOrderState("결제 대기");
				order.setDeliveryState("배송 대기");
				order.setUser(Users.builder().user_id(Long.valueOf(2)).build());
				
				//주문서 저장
				long order_id = orderRepository.save(order).getOrder_id();
				
				//배송정보 저장
				dto.setOrder(Orders.builder().order_id(order_id).build());
				deliveryRepository.save(dto.toDeliveryEntity());		
				
				//주문 상품 저장
				dto.toOrderItemsEntity();
				orderItemsRepository.save(dto.toOrderItemsEntity());
	
				
			} else {
				return new orderResponseDto(null,"품절된 상품 입니다.", false);
			}
		}
		return new orderResponseDto(ordercode,"주문이 완료되었습니다.", true);
		
		
	}
	
	@Transactional
	public void cancelOrder(OrderGoodsRequestDto dto) {
		orderRepository.cancelOrder("주문 취소(환불 대기)", "배송 취소", dto.getOrder_code()); //enum
	}
	
	private String makeOrderCode() throws Exception {
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			temp.append((char) ((rnd.nextInt(26)) + 65));
		}
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(d);
		String ORDER_CODE = ("S" + date + temp);
		
		return ORDER_CODE;
	}
	
	private boolean isProductStocked(OrderGoodsRequestDto dto) {
		boolean isStocked = false;
		GoodsDetail goods = goodsDetailRepository.getGoods(dto.getGd_id());
		long stock = 0;
		stock = goods.getGoods_stock();
		
		if(stock > 0) {
			isStocked = true;
		}
		return isStocked;
	}
	
}
