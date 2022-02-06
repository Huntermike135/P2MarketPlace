package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	@Autowired
	private CustomerRepository repo;
	@PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody Customer customerData){
		Customer customer=repo.getByUserName(customerData.getUsername());
		if(customer.getPassword().equals(customerData.getPassword()))
			return ResponseEntity.ok(customer);
			return (ResponseEntity<?>)ResponseEntity.internalServerError();
  }
}
