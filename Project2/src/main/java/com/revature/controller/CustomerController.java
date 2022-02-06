package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.revature.DTO.Credentials;
import com.revature.model.Customer;
import com.revature.Service.CustomerService;

@RestController("customerController")
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Customer>> getAllUsers() {
		return  new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
	}


	
	@PostMapping("/newuser")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.create(customer);
	}

	@PutMapping(path = "/updateinfo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createOrUpdateUserWithId(@RequestBody Customer customer, @PathVariable Integer id) {
		customer.setUserId(id);
		return new ResponseEntity<>(customerService.createOrUpdate(customer), HttpStatus.OK);

	}

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> attemptLogin(@RequestBody Credentials creds, HttpSession session) {
		Customer loggedInUser = customerService.verifyCredentials(creds.getUsername(), creds.getPassword());

		return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
	}
}