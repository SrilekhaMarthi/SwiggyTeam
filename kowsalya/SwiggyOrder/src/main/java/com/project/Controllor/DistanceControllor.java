package com.project.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entity.Distance;
import com.project.Response.APIResponse;
import com.project.Service.DistanceService;

@RestController
public class DistanceControllor {
	@Autowired
	private DistanceService distanceService;

	public DistanceControllor(DistanceService distanceService) {
		super();
		this.distanceService=distanceService;
	}

	@PostMapping("/addLocation")
	public APIResponse addLocation(@RequestBody Distance detail ) {
		System.out.println(detail.getLocation());
		return distanceService.addLocation(detail);
	}
    
	public double getChargeByLocation(@RequestBody String dec) {
			double x=distanceService.getChargeByLocation(dec);
			return x;
		}
	
	
}
