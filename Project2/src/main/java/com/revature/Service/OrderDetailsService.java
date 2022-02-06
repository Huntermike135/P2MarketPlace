package com.revature.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.revature.model.OrderDetails;
import com.revature.repository.OrderDetailsRepo;
@Service("orderdetailsService")
@Primary
public class OrderDetailsService {
	@Autowired
	public OrderDetailsRepo orderDetailsRepo;

	public List<OrderDetails> getAll() {
		return orderDetailsRepo.findAll();
	}

	public OrderDetails save(OrderDetails ol) {
		return orderDetailsRepo.save(ol);
	}

}

