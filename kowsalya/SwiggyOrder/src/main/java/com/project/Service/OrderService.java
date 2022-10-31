package com.project.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Entity.Orders;
import com.project.Repository.OrderRepository;
import com.project.Response.APIResponse;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Orders detail) {
		orderRepository.save(detail);
	}
	public APIResponse getOrder() {
		APIResponse apiResponse =new APIResponse();
		List<Orders> o=orderRepository.findAll();
		apiResponse.setData(o);
		return apiResponse;
	}
	public String calculateTime() {
		LocalDateTime now = LocalDateTime.now();	
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    String formatDateTime = now.format(format); 
		return formatDateTime;
	    
		}
	@Transactional
	public void cancelOrder(int id) {
		orderRepository.cancelOrder(id);	
	}
	@Transactional
	public void changeStatus(int id) {
		orderRepository.changeStatus(id);
	}
	@Transactional
	public void changeToDelivered(int id) {
		orderRepository.changeToDelivered(id);
		
	}
}
	/*public double calculate(Cart cart) {
		double subtotal=(double)cart.getSubTotal();
		double price=cart.getSubTotal() *0.3;
		double deliveryCharge=50.00;
		double total=price+deliveryCharge;
		return total;
	}	
	double subtotal=(double)Cart.getSubTotal();
	double price=Cart.getSt() *orders.GST;
	double deliveryCharge=50.00;
	
	public Orders addPrice(int price) {
		return orderRepository.save(price);
	}
	public boolean saveOrder(Cart cart) {
		double totalamount=calculate(cart);
		orderrepository.save(Order);	
	}
	*/
	/*public void saveOrder(Orders order, double total) {
		order.setPrice(total);
		order.setDeliveryCharge(50);
		
		orderrepository.save(order);
		}
	*/