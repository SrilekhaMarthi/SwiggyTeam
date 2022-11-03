package com.project.Controllor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entity.Offers;
import com.project.Response.APIResponse;
import com.project.Service.OfferService;

@RestController
public class OfferControllor {
	@Autowired
	private OfferService offerService;	
	public OfferControllor(OfferService offerService) {
		super();
		this.offerService=offerService;
	}
	String a;
	public String grade(double total) {
		if(total<1000) {
			a="A";
		}
		else if(1000 < total && total < 5000){
			a="B";
		}
		else if(5000< total && total <10000){
			a="C";
		}
		else{
			a="D";
		}
	    return a;
	}	
	@PostMapping("/addOffer")
	public APIResponse addOffer(@RequestBody Offers offers ) {
		return offerService.addOffer(offers);
	}	
	public double value(@PathVariable String grd) {
		return offerService.value(grd);	
	}
}