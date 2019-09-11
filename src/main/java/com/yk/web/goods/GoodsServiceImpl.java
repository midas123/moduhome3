package com.yk.web.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.web.dto.OrderGoodsRequestDto;

@Service
public class GoodsServiceImpl {
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private GoodsDetailRepository goodsDetailRepository;
	
	@Autowired
	private GoodsImagesRepository goodsImagesRepository;
	
	
	public List<Goods> getAllGoods() {
		return goodsRepository.findAll();
	}
	
//	public List<GoodsImages> getGoodsDetailImages(Long goods_id){
//		
//		return goodsImagesRepository.findGoodsImagesById(goods_id);
//	}
//	
	
}
