package com.spring.tely.controller;

import java.util.List;

import com.spring.tely.dto.CallDetailsDTO;
import com.spring.tely.dto.CustomerDTO;
import com.spring.tely.dto.FriendFamilyDTO;
import com.spring.tely.dto.LoginDTO;
import com.spring.tely.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerService custService;

	// Create a new customer
	
	@PostMapping(value = "/customers",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO custDTO) {
		logger.info("Creation request for customer {}", custDTO);
		custService.createCustomer(custDTO);
	}

	// Login
	
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		return custService.login(loginDTO);
	}

	// Fetches full profile of a specific customer
	
	@GetMapping(value = "/customers/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {

		logger.info("Profile request for customer {}", phoneNo);
		return custService.getCustomerProfile(phoneNo);
	}

	// Fetches call details of a specific customer
	
	@GetMapping(value = "/customers/{phoneNo}/calldetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {
		logger.info("Calldetails request for customer {}", phoneNo);
		return custService.getCustomerCallDetails(phoneNo);
	}

	// Save the friend details of a specific customer
	
	@PostMapping(value = "/customers/{phoneNo}/friends", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFriend(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, friendDTO);
		custService.saveFriend(phoneNo, friendDTO);
	}

}
