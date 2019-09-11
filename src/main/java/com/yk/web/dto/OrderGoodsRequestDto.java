package com.yk.web.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	private String item_quantity;
	
	private String item_option1;
	
	private String item_option2;
	
	private int item_price;
	
	private Map<String, String> delivery_info;
	
	private Map<String, String> payment_info;

	
	@JsonIgnore
	private Orders order;
	
	@JsonIgnore
	private Users user;
	
	
	public Orders toOrderEntity() {
		return Orders.builder()
				.orderer_name(delivery_info.get("orderer_name"))
				.payment(payment_info.get("payment"))
				.user(user)
				.build();
	}
	
	public OrderItems toOrderItemsEntity() {
		return OrderItems.builder()
				.item_option1(item_option1)
				.item_option2(item_option2)
				.item_name(item_name)
				.item_price(item_price)
				.item_quantity(item_quantity)
				.order(order)
				.build();
	}
	
	public Delivery toDeliveryEntity() {
		return Delivery.builder()
				.recipient_name(delivery_info.get("recipient_name"))
				.address1(delivery_info.get("address1"))
				.address2(delivery_info.get("address2"))
				.mobilephone_number(delivery_info.get("mobilephone_number"))
				.order(order)
				.build();
	}
	
}
