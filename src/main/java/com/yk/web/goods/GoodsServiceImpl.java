package com.yk.web.goods;

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
	
	
}
