package com.cwc.consuming.services;

import java.util.List;

import com.cwc.consuming.model.PostOfficeResponse;

public interface PostOfficeServices {
	
	public PostOfficeResponse fetchPostOfficeByCity(String city);
	
	public List<PostOfficeResponse> fetchPostOfficeByPinCode(String pincode);
	
	 

}
