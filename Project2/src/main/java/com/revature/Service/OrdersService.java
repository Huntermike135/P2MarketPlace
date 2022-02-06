package com.revature.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.model.Orders;
import com.revature.repository.OrderRepo;
@Service("orderService")
@Primary
public class OrdersService {
	   @Autowired
	    public OrderRepo orderRepo;
	    
	    public List<Orders> getAll()
	    {
	        return orderRepo.findAll();
	    }
	    
	    public Orders save(Orders ol)
	    {
	      return orderRepo.save(ol);
	    }
	
}
