package com.cwc.consuming.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.consuming.model.PostOfficeResponse;
import com.cwc.consuming.services.PostOfficeServices;

@RestController
@RequestMapping("/api/v1/postoffice")
public class PostOfficeController {

	@Autowired
	private PostOfficeServices postOfficeServices;
	
	@RequestMapping(value = "/byCity", 
			method = RequestMethod.GET, 
			consumes = MediaType.ALL_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PostOfficeResponse getPostalByCity(@RequestParam String city) {
		
		PostOfficeResponse postOfficeResponse = this.postOfficeServices.fetchPostOfficeByCity(city);
		
		return postOfficeResponse;
	}
	
	@GetMapping("/bypincode")
	public List<PostOfficeResponse> searchByPinCode(@PathParam("pincode") String pincode) {
		List<PostOfficeResponse> fetchPostOfficeByPinCode = this.postOfficeServices.fetchPostOfficeByPinCode(pincode);
		return fetchPostOfficeByPinCode;
	}
}
