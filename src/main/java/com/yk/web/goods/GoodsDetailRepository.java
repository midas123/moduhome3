package com.yk.web.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDetailRepository extends JpaRepository<GoodsDetail, Long>{
	@Query(value="select * from goods_detail where gd_id = ?", nativeQuery=true)
	GoodsDetail getGoods(long gd_id);
	
	@Modifying
	@Query(value="UPDATE goods_detail g SET g.goods_stock = g.goods_stock + ? WHERE g.gd_id = ?", nativeQuery=true)
	void updateStock(int quantity, long gd_id);
}
