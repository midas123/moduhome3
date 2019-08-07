package com.yk.web.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long gd_id;
	
	@Column
	private String goods_stock;
	
	@Column
	private String goods_option1;

	@Column
	private String goods_option2;
	
	@Column
	private String goods_sellcount;
	
	@Column
	private String goods_price;
	
	@Column
	private String goods_disprice;

	@Column
	private String goods_disdate;
	
	@Column
	private String goods_blinded;
	
	@JsonBackReference 
	@OneToOne
	@JoinColumn(name="goods", referencedColumnName="goods_id")
	private Goods goods;

	@Builder
	public GoodsDetail(long gd_id, String goods_stock, String goods_option1, String goods_option2,
			String goods_sellcount, String goods_price, String goods_disprice, String goods_disdate,
			String goods_blinded, Goods goods) {
		super();
		this.gd_id = gd_id;
		this.goods_stock = goods_stock;
		this.goods_option1 = goods_option1;
		this.goods_option2 = goods_option2;
		this.goods_sellcount = goods_sellcount;
		this.goods_price = goods_price;
		this.goods_disprice = goods_disprice;
		this.goods_disdate = goods_disdate;
		this.goods_blinded = goods_blinded;
		this.goods = goods;
	}

}
