package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Orders;

@Repository("orderRepo")
public interface OrderRepo extends JpaRepository<Orders, Integer> {

	Orders findByOrderId(Integer orderId);

	List<Orders> findAllByUserId(Integer id);
}
