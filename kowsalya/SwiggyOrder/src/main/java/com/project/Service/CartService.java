package com.project.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Controllor.DeliveryManControllor;
import com.project.Controllor.DistanceControllor;
import com.project.Controllor.OfferControllor;
import com.project.Controllor.OrderControllor;
import com.project.Entity.Auditable;
import com.project.Entity.Cart;
import com.project.Entity.DeliveryMan;
import com.project.Entity.Orders;
import com.project.Repository.CartRepository;
import com.project.Response.APIResponse;

@Service
public class CartService extends Auditable{
	private static final String paymentMode = null;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrderControllor orderControllor;
	@Autowired
	private DistanceControllor distanceControllor;
	@Autowired
	private DeliveryManControllor deliveryManControllor;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OfferControllor offerControllor;
	
	private Orders order = new Orders();
	DeliveryMan deliveryMan= new DeliveryMan();

	public void calculate(Cart cart) {
		String userName="Arivu";
		String userId="1";
		double gst=0.003;
		double subtotal=cart.getSubTotal();	
		double deliveryCharge=distanceControllor.getChargeByLocation(cart.getFinalLocation());
		deliveryMan = deliveryManControllor.getDetails(cart.getFinalLocation());
		double price=subtotal*gst;
		double total=price+deliveryCharge+subtotal;
		String grd=offerControllor.grade(total);
		double value=offerControllor.value(grd);
		total=total - (total*value)/100;
		
		order.setCreditedOn(getCreditedOn());
		order.setUpdatedOn(getUpdatedOn());
		order.setPrice(total);
		order.setDeliveryCharge(deliveryCharge);
		order.setDeliveryManId(deliveryMan.getDeliveryManId());
		order.setDeliveryPhoneNo(deliveryMan.getDeliveryManPhoneNo());
		order.setPaymentMode(order.getPaymentMode());
		order.setOrderStatus(order.getOrderStatus());
		order.setUserId(userId);
		order.setUserName(userName);
		order.setStatus(order.getStatus());
		orderControllor.addOrder(order);	
	}	
	public APIResponse addCart(Cart detail) {
		APIResponse apiResponse=new APIResponse();
		apiResponse.setData(cartRepository.save(detail));
		calculate(detail);
		return apiResponse;	
	}
}
/*String dec=cart.getLocation();
if(dec==null) {
	
}*/