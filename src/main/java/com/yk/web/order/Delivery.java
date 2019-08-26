package com.yk.web.order;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long delivery_id;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String recipient_name;
	
	@Column
	private String mobilephone_number;
	
//	@ManyToMany(mappedBy="deliveries")
//	private Set<Orders> orders = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="fk_order_id")
	private Orders order;

	@Builder
	public Delivery(long delivery_id, String address1, String address2, String recipient_name,
			String mobilephone_number, Orders order) {
		this.delivery_id = delivery_id;
		this.address1 = address1;
		this.address2 = address2;
		this.recipient_name = recipient_name;
		this.mobilephone_number = mobilephone_number;
		this.order = order;
	}
	
	public void setOrder(Orders order) {
		this.order = order;
	}
	
}
