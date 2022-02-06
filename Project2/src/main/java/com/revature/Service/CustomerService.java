package com.revature.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Customer;
import com.revature.repository.CustomerRepo;

@Service("customerService")
public class CustomerService {
	@Autowired
	CustomerRepo CustomerRepository;
	
	
	public List<Customer> getAll(){
		return CustomerRepository.findAll();
	}
	

	public Customer create(Customer customer) {
		return CustomerRepository.save(customer);
	}
	
	public Customer update(Customer Customer) {
		Optional<Customer> existingCustomer = CustomerRepository.findById(Customer.getUserId());
		if(existingCustomer.isPresent()) {
			return CustomerRepository.save(Customer);
		} else {
			return null;
		}
	}
	public Customer verifyCredentials(String customername, String password) {
		List<Customer> loggedInCustomerList = CustomerRepository.verifyCustomer(customername, password);
		if(loggedInCustomerList.size() > 0) {
			Customer loggedInCustomer = loggedInCustomerList.get(0);
			return loggedInCustomer;
		} else {
			return null;
		}
	}
	
	public Customer createOrUpdate(Customer Customer) {
		Customer updatedCustomer = CustomerRepository.save(Customer);
		System.out.println(updatedCustomer);
		return updatedCustomer;
	}
	
	public Customer getCustomer (Integer id) {
        return  CustomerRepository.findById(id).orElseThrow();
    }
	
	public void delete(Integer id) {
		CustomerRepository.deleteById(id);
	}


	
}
