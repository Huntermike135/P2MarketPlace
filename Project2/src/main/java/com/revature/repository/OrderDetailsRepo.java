package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.OrderDetails;

@Repository("orderdetailsRepo")
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

	OrderDetails findByOrderId(Integer orderlineId);

	@Query("select o from OrderDetails o where o.orderId=:orderId") 
	List<OrderDetails> findAllByOrderId(Integer orderId);
}
