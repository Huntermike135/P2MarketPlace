package com.revature.repository;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;
@Repository("customerRepo")
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	 List<Customer> findAll();
	 Optional<Customer> findById (Integer id);
	@Query(value="select * from Market_Customers mc where mc.username= :username and mc.password = :password", nativeQuery=true)
	List<Customer> verifyCustomer(String username, String password);
}