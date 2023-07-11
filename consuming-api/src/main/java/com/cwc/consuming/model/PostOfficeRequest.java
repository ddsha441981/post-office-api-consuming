package com.cwc.consuming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "postoffice")
public class PostOfficeRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("BranchType")
	private String branchType;
	
	@JsonProperty("DeliveryStatus")
	private String deliveryStatus;
	
	@JsonProperty("Circle")
	private String circle;
	
	@JsonProperty("District")
	private String district;
	
	@JsonProperty("Division")
	private String division;
	
	@JsonProperty("Region")
	private String region;
	
	@JsonProperty("State")
	private String state;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("PINCode")
	private String pinCode;
	
}
