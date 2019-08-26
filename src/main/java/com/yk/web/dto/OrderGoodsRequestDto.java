package com.yk.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yk.web.order.Delivery;
import com.yk.web.order.OrderItems;
import com.yk.web.order.Orders;
import com.yk.web.users.Users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderGoodsRequestDto {
	private long goods_id;
	
	private long gd_id;
	
	private String order_code;
	
	private String item_name;

	private String order_quantity;
	
	private String item_option1;
	
	private String item_option2;
	
	private int item_price;
	
	private String orderer_name;
	
	private String recipient_name;
	
	private String payment;
	
	private String address1;
	
	private String address2;
	
	private String mobilephone_number;
	
	@JsonIgnore
	private Orders order;
	
	@JsonIgnore
	private Users user;
	
	
	public Orders toOrderEntity() {
		return Orders.builder()
				.orderer_name(orderer_name)
				.payment(payment)
				.user(user)
				.build();
	}
	
	public OrderItems toOrderItemsEntity() {
		return OrderItems.builder()
				.item_option1(item_option1)
				.item_option2(item_option2)
				.item_name(item_name)
				.item_price(item_price)
				.order_quantity(order_quantity)
				.order(order)
				.build();
	}
	
	public Delivery toDeliveryEntity() {
		return Delivery.builder()
				.recipient_name(recipient_name)
				.address1(address1)
				.address2(address2)
				.mobilephone_number(mobilephone_number)
				.order(order)
				.build();
	}
	
}
