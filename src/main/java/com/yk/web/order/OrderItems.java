package com.yk.web.order;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrderItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long item_id;

	@Column
	private String item_name;
	
	@Column
	private String item_option1;
	
	@Column
	private String item_option2;
	
	@Column
	private String item_quantity;
	
	@Column
	private int item_price;

	@ManyToOne
	@JoinColumn(name="fk_order_id")
	private Orders order;

	@Builder
	public OrderItems(long item_id, String item_name, String item_option1, String item_option2, String item_quantity,
			int item_price, Orders order) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_option1 = item_option1;
		this.item_option2 = item_option2;
		this.item_quantity = item_quantity;
		this.item_price = item_price;
		this.order = order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
}
