package com.project.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entity.DeliveryMan;
import com.project.Entity.Orders;
import com.project.Response.APIResponse;
import com.project.Service.OrderService;

@RestController
public class OrderControllor {
	@Autowired
	private OrderService orderService;
	private Orders orders= new Orders();
	public DeliveryMan deliveryMan;
	//private CartService cartService;

	public void addOrder(@RequestBody Orders detail ) {
		orders.setPrice(detail.price);
		orders.setDeliveryCharge(detail.deliveryCharge);
		orderService.addOrder(detail);
	}	
	@GetMapping("/getOrder")
	public APIResponse getOrder() {
		return orderService.getOrder();
	}
	//int z=orders.getOrderId();
	@PatchMapping("/cancelOrder/{id}")	
	public void cancelOrder(@PathVariable int id) {	
		//System.out.println(z);
		orderService.cancelOrder(id);
	}
	@PatchMapping("/changeStatus/{id}")
	public void changeStatus(@PathVariable int id) {
		orderService.changeStatus(id);
	}	
	@PatchMapping("/changeToDelivered/{id}")
	public void changeToDelivered(@PathVariable int id) {
		orderService.changeToDelivered(id);
	}
}
//@PostMapping("/addOrder")
//private Cart cart;
//	public OrderControllor(OrderService orderService) {
//	     super();
//	     this.orderService=orderService;
//	}	