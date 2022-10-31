package com.project.Controllor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entity.DeliveryMan;
import com.project.Response.APIResponse;
import com.project.Service.DeliveryManService;

@RestController
public class DeliveryManControllor {
		@Autowired
		private DeliveryManService deliveryManService;
		
		public DeliveryManControllor(DeliveryManService deliveryManService) {
		     super();
		     this.deliveryManService=deliveryManService;
		}	
		@PostMapping("/addMan")
		public APIResponse addMan(@RequestBody DeliveryMan detail ) {
			return deliveryManService.addMan(detail);
		}
		@PostMapping("/addMans")
		public APIResponse addMans(@RequestBody List<DeliveryMan> details) {
			return deliveryManService.addMans(details);
		}
		@GetMapping("/displayMan")
		public APIResponse displayMan() {
			return deliveryManService.displayMan();
		}
		@GetMapping("/findManById/{id}")
		public APIResponse findManById(@PathVariable int id ) {
			return deliveryManService.findManById(id);
		}
		@PutMapping("/updateMan")
	    public APIResponse updateMan(@RequestBody DeliveryMan detail) {
	        return deliveryManService.updateMan(detail);
	    }
	    @DeleteMapping("/deleteMan/{id}")
	    public APIResponse deleteMan(@PathVariable int id) {
	        return deliveryManService.deleteMan(id);
	    }
	    public DeliveryMan getDetails(@RequestBody String l) {
		  return deliveryManService.getDetails(l);	
		}
}
