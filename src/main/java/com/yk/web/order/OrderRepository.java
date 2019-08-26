package com.yk.web.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
	@Modifying
	@Query(value="UPDATE orders o SET o.order_state =?, o.delivery_state = ? WHERE o.order_code = ?", nativeQuery=true)
	void cancelOrder(String order_state, String delivery_state, String order);
}
