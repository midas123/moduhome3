package com.yk.web.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.yk.web.users.Users;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long order_id;
	
	@Column
	private String order_code;

	@Column
	private String Orderer_name;
	
	@Column
	private String payment;

	@Column
	private String order_state;
	
	@Column
	private String delivery_state;
	
	@OneToMany(mappedBy="order")
	List<OrderItems> items = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="fk_user_id")
	private Users user;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "orders_deliveries",
//	            joinColumns = @JoinColumn(name = "order_id"),
//	            inverseJoinColumns = @JoinColumn(name = "delivery_id"))
//	private Set<Delivery> deliveries = new HashSet<>();
	
	@OneToOne(mappedBy="order")
	private Delivery delivery;
	
	@Builder
	public Orders(long order_id, String order_code, String orderer_name, String payment, String order_state,
			String delivery_state, List<OrderItems> items, Users user, Delivery delivery) {
		this.order_id = order_id;
		this.order_code = order_code;
		Orderer_name = orderer_name;
		this.payment = payment;
		this.order_state = order_state;
		this.delivery_state = delivery_state;
		this.items = items;
		this.user = user;
		this.delivery = delivery;
	}
	
	
	public void setOrderCode(String order_code) {
		this.order_code = order_code;
	}
	
	public void setOrderState(String order_state) {
		this.order_state = order_state;
	}
	
	public void setDeliveryState(String delivery_state) {
		this.delivery_state = delivery_state;
	}
	
	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}


	
}