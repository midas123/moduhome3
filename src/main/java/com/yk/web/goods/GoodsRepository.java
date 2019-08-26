package com.yk.web.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>{
	@Query(value="select * from goods where goods_id = ?", nativeQuery=true)
	Goods getGoods(long goods_id);
}
