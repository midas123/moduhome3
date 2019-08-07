package com.yk.web.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl {
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private GoodsDetailRepository goodsDetailRepository;
	
	@Autowired
	private GoodsImagesRepository goodsImagesRepository;
	
	
	public List<Goods> getAllGoods() {
		List<Goods> goods = goodsRepository.findAll();
		
		return goods;
	}
	
	
}
