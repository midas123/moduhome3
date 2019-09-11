package com.yk.web.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsImagesRepository extends JpaRepository<GoodsImages, Long>{
//	@Query("SELECT * FROM goods_images g WHERE g.goods_id = ? ORDER BY goods_image_id ASC")
//	List<GoodsImages> findGoodsImagesById(Long goods_id);
}
