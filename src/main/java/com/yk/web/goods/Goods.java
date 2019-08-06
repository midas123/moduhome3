package com.yk.web.goods;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Goods {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long goods_id;
	
	@Column
	private String goods_name;
	
	@Column
	private String goods_category1;
	
	@Column
	private String goods_category2;
	
	@Column
	private String goods_brname;
	
	@Column
	private String goods_thumnail;
	
	@Column
	private String goods_blinded;
	
	@Column
	private String goods_date;
	
	@Column
	private String goods_relevant;
	
	@JsonManagedReference 
	@OneToOne(mappedBy = "goods", fetch = FetchType.LAZY)
	private GoodsDetail goodsDetail;
	
	@JsonManagedReference 
	@OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
	private List<GoodsImages> goodsImages = new ArrayList<>();

	@Builder
	public Goods(long goods_id, String goods_name, String goods_category1, String goods_category2, String goods_brname,
			String goods_thumnail, String goods_blinded, String goods_date, String goods_relevant,
			GoodsDetail goodsDetail) {
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_category1 = goods_category1;
		this.goods_category2 = goods_category2;
		this.goods_brname = goods_brname;
		this.goods_thumnail = goods_thumnail;
		this.goods_blinded = goods_blinded;
		this.goods_date = goods_date;
		this.goods_relevant = goods_relevant;
		this.goodsDetail = goodsDetail;
	}

	
	
}
