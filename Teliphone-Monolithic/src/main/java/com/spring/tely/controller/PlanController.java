package com.spring.tely.controller;

import java.util.List;

import com.spring.tely.dto.PlanDTO;
import com.spring.tely.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PlanController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    PlanService planService;

	// Fetches all plan details
	@GetMapping(value = "/plans", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans() {
		return planService.getAllPlans();
	}


}
