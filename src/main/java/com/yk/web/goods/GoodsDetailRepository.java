package com.yk.web.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDetailRepository extends JpaRepository<GoodsDetail, Long>{
	@Query(value="select * from goods_detail where gd_id = ?", nativeQuery=true)
	GoodsDetail getGoods(long goods_id);
}
