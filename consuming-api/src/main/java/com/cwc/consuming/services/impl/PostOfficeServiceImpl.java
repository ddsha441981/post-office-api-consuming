package com.cwc.consuming.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cwc.consuming.model.PostOfficeRequest;
import com.cwc.consuming.model.PostOfficeResponse;
import com.cwc.consuming.repository.PostOfficeRepository;
import com.cwc.consuming.services.PostOfficeServices;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostOfficeServiceImpl implements PostOfficeServices {

	@Autowired
	private WebClient.Builder webClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PostOfficeRepository postOfficeRepository;

	@Override
	public PostOfficeResponse fetchPostOfficeByCity(String cityValue) {
		String apiUrl = "https://api.postalpincode.in/postoffice/{city}";
		String url = apiUrl.replace("{city}", cityValue);

		// Now call RestTemplete
		ResponseEntity<PostOfficeResponse[]> postOfficeResponse = restTemplate.getForEntity(url,
				PostOfficeResponse[].class);
		System.out.println("Response Status Code is : " + postOfficeResponse.getStatusCodeValue());
		PostOfficeResponse[] postOfficeResponses = postOfficeResponse.getBody();
		for (PostOfficeResponse response : postOfficeResponses) {
			List<PostOfficeRequest> postOffice = response.getPostOffice();
			System.out.println(postOffice);
			this.postOfficeRepository.saveAll(postOffice);

//			for(PostOfficeRequest post : postOffice) {
//				System.out.println(post.getName() + "****" + post.getCountry() + "***" + post.getPinCode());
//			}
		}

		return postOfficeResponses[0];
	}

	@Override
	public List<PostOfficeResponse> fetchPostOfficeByPinCode(String pincode) {
		// https://api.postalpincode.in/pincode/110001
		List<PostOfficeResponse> list = webClient.build().get().uri("https://api.postalpincode.in/pincode/" + pincode)
				.retrieve().bodyToFlux(PostOfficeResponse.class).collectList().block();
		return list;
	}

}
