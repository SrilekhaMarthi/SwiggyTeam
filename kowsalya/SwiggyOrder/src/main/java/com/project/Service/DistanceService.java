package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Entity.Distance;
import com.project.Repository.DistanceRepository;
import com.project.Response.APIResponse;

@Service
public class DistanceService {

	@Autowired
	private DistanceRepository distanceRepository;
	
	public APIResponse addLocation(Distance detail) {
		APIResponse apiResponse=new APIResponse();
	    apiResponse.setData(distanceRepository.save(detail)); 
	    return apiResponse;
	}

	public double getChargeByLocation(String dec) {
		double y=distanceRepository.getChargeByLocation(dec).getCharge();
		return y;
	}
	
	
}
