package com.yk.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yk.web.goods.GoodsDetail;
import com.yk.web.order.OrderItems;
import com.yk.web.order.OrderRepository;
import com.yk.web.order.Orders;
import com.yk.web.users.Users;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class OrderServiceImplTest {
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void test() {
		
		OrderItems item = OrderItems.builder()
				.item_name("의자")
				.item_option1("기본")
				.item_price(70000).build();
		List<OrderItems> items = new ArrayList<>();
		items.add(item);
		orderRepository.save(Orders.builder()
				.order_code("1234")
				.delivery_state("배송 대기")
				.items(items)
				.user(Users.builder().user_id(Long.valueOf(2)).build())
				.build());
		
		List<Orders> orders = orderRepository.findAll();
		Orders order = orders.get(0);
		
		assertThat(order.getOrder_code(), is("1234"));
		
	}
	
}
