package com.yk.web.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class GoodsImages {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long good_image_id;
	
	@Column
	private String image_name;
	
	@JsonBackReference 
	@ManyToOne
	@JoinColumn(name="goods_id", referencedColumnName="goods_id")
	private Goods goods;
	
}
