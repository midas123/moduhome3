package com.yk.web.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.web.dto.OrderGoodsRequestDto;
import com.yk.web.goods.Goods;
import com.yk.web.goods.GoodsDetail;
import com.yk.web.goods.GoodsRepository;
import com.yk.web.users.Users;

@Service
public class OrderServiceImpl {
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	public String orderGoods(OrderGoodsRequestDto dto) {
		System.out.println("orderGoods: "+dto.toString());
		Goods good = goodsRepository.getGoods(dto.getGoods_id());
		System.out.println("goods: "+good);
		System.out.println(good.getGoodsDetail().size());
		long stock = 0;
		for(GoodsDetail gd : good.getGoodsDetail()) {
			long a = dto.getGd_id();
			long b = gd.getGd_id();
			System.out.println("ab: "+a+b);
			if(a == b) {
				System.out.println("check: "+dto.getGd_id()+" "+gd.getGd_id());
				stock = gd.getGoods_stock();
			}
		}
		if(stock <=0) {
			//상품 품절
			return "품절된 상품 입니다.";
		}
		
		System.out.println("make order");
		Orders order = dto.toOrderEntity();		
		order.setOrderCode("1234");
		order.setPayment("현금");
		order.setOrderState("결제 완료");
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
		

		return "주문이 완료되었습니다.";
		
	}
	@Transactional
	public void cancelOrder(OrderGoodsRequestDto dto) {
		orderRepository.cancelOrder("주문 취소(환불 대기)", "배송 취소", dto.getOrder_code()); //enum
	}
	
}
