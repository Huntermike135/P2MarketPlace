package com.revature.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Service.OrderDetailsService;
import com.revature.Service.OrdersService;
import com.revature.model.ClientOrder;
import com.revature.model.Item;
import com.revature.model.OrderDetails;
import com.revature.model.Orders;
import com.revature.repository.ItemRepo;
import com.revature.repository.OrderDetailsRepo;

@RestController("ordersController")
@RequestMapping("/order")
public class OrdersController
{
    @Autowired
    OrdersService orderService;
    
    @Autowired
    OrderDetailsService orderdetailService;
    
    @Autowired
    OrderDetailsRepo orderlineRepo; 
    
    @Autowired
    ItemRepo itemRepo;
    
    //GETS all the orders in the orders table
    @CrossOrigin(origins = "*")
    @GetMapping("/orderall")
    public ResponseEntity<List<Orders>> getAll()
    {
        System.out.println("GET /orders has been hit");
      
        return new ResponseEntity<>(orderService.getAll(),HttpStatus.OK);
    }
    
    // Place items into an order
    @CrossOrigin(origins = "*")
    @PostMapping("/orderitems")
    public Orders addNewOrder(@RequestBody ClientOrder ord)
    {
      System.out.println("POST /orderItems has been reached");
      System.out.println("ord="+ord.toString());
      
      
      if(ord.userId==null)       
      {
        System.out.println("userId="+ord.userId);
        System.out.println("Could not place order, userId was not in request body");
        return null;
      }
      
      if(ord.itemIds==null)     
      {
        System.out.println("itemIds="+ord.itemIds);
        System.out.println("Could not place order, itemIds were not in request body");
        return null;
      }

   
      Orders newOrder=new Orders(
            0,              
            ord.userId,                  
            LocalDate.now()
            
          );
      
      newOrder=orderService.orderRepo.save(newOrder);
      
     
      int newOrderId=newOrder.getOrderId();
      
      System.out.println("newOrderId="+newOrderId);
      
      for(int itemId:ord.itemIds)
      {
        OrderDetails newOrderline=new OrderDetails(
              0,                
              newOrderId,       
              itemId,           
              ord.userId,       
              LocalDate.now(),   
              1                   
              
            );
        
        orderdetailService.orderDetailsRepo.save(newOrderline);
      }
      
      return newOrder;
    }
    
    //GETS a single order by order_id
    @CrossOrigin(origins = "*")
    @GetMapping("/orderId/{id}")
    public Orders getOneWithId(@PathVariable Integer id)
    {
      return orderService.orderRepo.findByOrderId(id);
    }
    
    //GETS all orders by user_id
    @CrossOrigin(origins = "*")
    @GetMapping("/orderall/{userId}")
    public List<Orders> getAllWithId(@PathVariable Integer userId)
    {
      return orderService.orderRepo.findAllByUserId(userId);
    }
    
    //GETS all items by order_id [ {itemObject}, {itemObject} ]
    @CrossOrigin(origins = "*")
    @GetMapping("/orderitems/{orderId}")
    public List<Item> getAllItemsByOrderId(@PathVariable Integer orderId)
    {
      List<OrderDetails> ordLines=orderlineRepo.findAllByOrderId(orderId);
      
      //get each item using each orderline, no time to come up with a better way
      List<Item> itemsInAnOrder=new ArrayList<Item>();
      
      for(OrderDetails ordLine:ordLines)
      {
        Item itemInOrderline=itemRepo.findByItemId(ordLine.itemId);
        itemsInAnOrder.add(itemInOrderline);
      }
      
      return itemsInAnOrder;
    }
    
    //GETS all orderDetails in the orderDetails table
    //Needs Work
    @CrossOrigin(origins = "*")
    @GetMapping("/orders/items")
    public OrderDetails getAllOrderlines()
    {
      System.out.println("GET /orders/items has been hit");
      
      OrderDetails aNewRow=new OrderDetails();
      aNewRow.orderlineId=1;
      aNewRow.orderId=1;
      aNewRow.itemId=1;
      
      System.out.println(" aNewRow="+aNewRow);

      return aNewRow;
    }
}
