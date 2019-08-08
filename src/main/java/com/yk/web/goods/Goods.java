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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
	private String goods_thumbnail;
	
	@Column
	private String goods_date;
	
	@Column
	private String goods_relevant;
	
	@JsonManagedReference 
	@OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
	private List<GoodsDetail> goodsDetail = new ArrayList<>();
	
	@JsonManagedReference 
	@OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
	private List<GoodsImages> goodsImages = new ArrayList<>();

	@Builder
	public Goods(long goods_id, String goods_name, String goods_category1, String goods_category2, String goods_brname,
			String goods_thumbnail, String goods_date, String goods_relevant, List<GoodsDetail> goodsDetail,
			List<GoodsImages> goodsImages) {
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_category1 = goods_category1;
		this.goods_category2 = goods_category2;
		this.goods_brname = goods_brname;
		this.goods_thumbnail = goods_thumbnail;
		this.goods_date = goods_date;
		this.goods_relevant = goods_relevant;
		this.goodsDetail = goodsDetail;
		this.goodsImages = goodsImages;
	}


	
	
}
