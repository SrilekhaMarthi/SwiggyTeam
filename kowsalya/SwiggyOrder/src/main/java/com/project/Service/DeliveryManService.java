package com.project.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Entity.DeliveryMan;
import com.project.Repository.DeliveryManRepository;
import com.project.Response.APIResponse;

@Service
public class DeliveryManService {
	@Autowired
	private DeliveryManRepository deliveryManRepository;
	
    public APIResponse addMan(DeliveryMan detail) {
    	APIResponse apiResponse=new APIResponse();
    	apiResponse.setData(deliveryManRepository.save(detail));
		return apiResponse;
	}
    public APIResponse addMans(List<DeliveryMan> details) {
    	APIResponse apiResponse =new APIResponse();
    	List<DeliveryMan> delivery=deliveryManRepository.saveAll(details);
    	apiResponse.setData(delivery);
    	return apiResponse;
	}
    public APIResponse  displayMan() {
    	APIResponse apiResponse=new APIResponse();
    	List<DeliveryMan> delivery=deliveryManRepository.findAll();
    	apiResponse.setData(delivery);
    	return apiResponse;
	}
    public APIResponse findManById(int id) {
    	APIResponse apiResponse=new APIResponse();
    	apiResponse.setData(deliveryManRepository.findById(id).orElse(null));
		return apiResponse;
	}
    public APIResponse updateMan(DeliveryMan Details) {
    	APIResponse apiResponse=new APIResponse();
    	DeliveryMan existingMan=deliveryManRepository.findById(Details.getDeliveryManId()).orElseThrow();
    	existingMan.setDeliveryManId(Details.getDeliveryManId());
    	existingMan.setDeliveryManName(Details.getDeliveryManName());
    	existingMan.setDeliveryManPhoneNo(Details.getDeliveryManPhoneNo());
    	existingMan.setDeliveryManLocation(Details.getDeliveryManLocation());
    	apiResponse.setData(deliveryManRepository.save(Details));	
		return apiResponse;
	}
	public APIResponse deleteMan(int id) {
		APIResponse apiResponse=new APIResponse();
		deliveryManRepository.findById(id).orElseThrow();
		deliveryManRepository.deleteById(id);
		apiResponse.setData("Deleted Successfully");
		return apiResponse;
	}
	public DeliveryMan getDetails(String l) {
		return deliveryManRepository.getDetails(l);
		
	}
}
	/*public int getDetails(String l) {
			int x = deliveryManRepository.getDetails(l).getDeliveryManId();
			return x;
	
}*/