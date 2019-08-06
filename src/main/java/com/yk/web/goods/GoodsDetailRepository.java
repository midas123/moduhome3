package com.yk.web.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDetailRepository extends JpaRepository<GoodsDetail, Long>{

}
