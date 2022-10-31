package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Controllor.DeliveryManControllor;
import com.project.Controllor.DistanceControllor;
import com.project.Controllor.OfferControllor;
import com.project.Controllor.OrderControllor;
import com.project.Entity.Cart;
import com.project.Entity.DeliveryMan;
import com.project.Entity.Orders;
import com.project.Repository.CartRepository;
import com.project.Response.APIResponse;

@Service
public class CartService {
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
	DeliveryMan dmi= new DeliveryMan();

	public void calculate(Cart cart) {
		String date=orderService.calculateTime();
		double subtotal=cart.getSubTotal();
		/*String dec=cart.getL();
		if(dec==null) {
			
		}*/
		System.out.println(cart.getL());
		double dc=distanceControllor.getChargeByLocation(cart.getL());
	    dmi = deliveryManControllor.getDetails(cart.getL());
		//System.out.println(cart.getSubTotal());
		double price=subtotal*0.3/100;
		double deliveryCharge=dc;
		System.out.println(dc);	
		double total=price+deliveryCharge+subtotal;
		String grd=offerControllor.grade(total);
		System.out.println(grd);
		double v=offerControllor.value(grd);
		System.out.println(v);
		total=total - (total*v)/100;
		String pm="COD";
		String os="ACTIVE";
		int a=1;
		String b="Arivu";
		order.setPrice(total);
		order.setDeliveryCharge(deliveryCharge);		
		order.setOrderedON(date);
		order.setDeliveryManId(dmi.getDeliveryManId());
		order.setDeliveryPhoneNo(dmi.getDeliveryManPhoneNo());
		order.setPaymentMode(pm);
		order.setOrderStatus(os);
		order.setUserId(a);
		order.setUserName(b);
		
		System.out.println(order.getDeliveryManId());
		//System.out.println(order.getOrderId());
		order.setStatus("Preparing");
		String date1=orderService.calculateTime();
		order.setUpdatedOn(date1);
		orderControllor.addOrder(order);
		
	}	
	
	
	public APIResponse addCart(Cart detail) {
		APIResponse apiResponse=new APIResponse();
		apiResponse.setData(cartRepository.save(detail));
		System.out.println(detail.getSubTotal());
		calculate(detail);
		System.out.println("after calculating");
		return apiResponse;	
	}
}
/*return total;		
System.out.println(total);
order.setPrice(total);
order.setDeliveryCharge(50);
System.out.println("before saving order repository");
//orderService.saveOrder(order,total);
orderRepository.save(order );*/