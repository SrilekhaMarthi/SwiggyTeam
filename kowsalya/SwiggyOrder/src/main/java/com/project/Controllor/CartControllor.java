package com.project.Controllor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entity.Cart;
import com.project.Response.APIResponse;
import com.project.Service.CartService;

@RestController
public class CartControllor {
	
	@Autowired
	private CartService cartService;
	
	public CartControllor(CartService cartService) {
	     super();
	     this.cartService=cartService;
	}
	@PostMapping("/addCart")
	public APIResponse addCart(@RequestBody Cart detail) {
		return cartService.addCart(detail);
	}
}