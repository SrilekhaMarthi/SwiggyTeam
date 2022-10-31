package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Entity.Offers;
import com.project.Repository.OfferRepository;
import com.project.Response.APIResponse;

@Service
public class OfferService {
	@Autowired
	private OfferRepository offerRepository;
	
	public APIResponse addOffer(Offers offers) {
		APIResponse apiResponse=new APIResponse();
	    apiResponse.setData(offerRepository.save(offers)); 
	    return apiResponse;
	}
	public double value(String grd) {
		 double k=offerRepository.value(grd).getOffer();
		 return k;	
	}

}
