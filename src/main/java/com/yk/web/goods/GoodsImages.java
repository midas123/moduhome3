package com.yk.web.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsImages {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long goods_image_id;
	
	@Column
	private String image_name;
	
	@JsonBackReference 
	@ManyToOne
	@JoinColumn(name="goods_id", referencedColumnName="goods_id")
	private Goods goods;
	
	@Builder
	public GoodsImages(long goods_image_id, String image_name, Goods goods) {
		super();
		this.goods_image_id = goods_image_id;
		this.image_name = image_name;
		this.goods = goods;
	}
	
	
	
}
