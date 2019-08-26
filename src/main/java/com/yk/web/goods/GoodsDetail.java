package com.yk.web.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yk.web.order.Orders;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long gd_id;
	
	@Column
	private int goods_stock;
	
	@Column
	private String goods_option1;

	@Column(columnDefinition="INT(11)")
	private String goods_option2;
	
	@Column(columnDefinition="INT", length=11)
	private int goods_sellcount;
	
	@Column(columnDefinition="Decimal(7,0) default '0'")
	private BigDecimal goods_price;
	
	@Column(columnDefinition="Decimal(7,0) default '0'")
	private BigDecimal goods_disprice;
	
	@Column
	private boolean goods_blinded;
	
	@JsonBackReference 
	@ManyToOne
	@JoinColumn(name="goods_id", referencedColumnName="goods_id")
	private Goods goods;
	

	@Builder
	public GoodsDetail(long gd_id, int goods_stock, String goods_option1, String goods_option2,
			int goods_sellcount, BigDecimal goods_price, BigDecimal goods_disprice,
			boolean goods_blinded, Goods goods) {
		super();
		this.gd_id = gd_id;
		this.goods_stock = goods_stock;
		this.goods_option1 = goods_option1;
		this.goods_option2 = goods_option2;
		this.goods_sellcount = goods_sellcount;
		this.goods_price = goods_price;
		this.goods_disprice = goods_disprice;
		this.goods_blinded = goods_blinded;
		this.goods = goods;
	}

}
