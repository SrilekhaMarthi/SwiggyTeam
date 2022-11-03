package com.project.Service;
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