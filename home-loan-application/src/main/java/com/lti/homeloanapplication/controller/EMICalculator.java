package com.lti.homeloanapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.homeloanapplication.entity.LoanInfo;
import com.lti.homeloanapplication.service.EMICalculatorServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EMICalculator {
	
	@Autowired
	private EMICalculatorServiceImpl service;
	
	@PostMapping("/calculateInterestRate")
	public LoanInfo calculateInterestRate(@RequestBody LoanInfo loanInfo)
	{
		return service.calculateInterestRate(loanInfo);
	}
	
	
	@PostMapping("/calculateEMI")
	public LoanInfo calculateEMI(@RequestBody LoanInfo loanInfo)
	{
		String uri = "http://localhost:8092/calculateInterestRate";
	    RestTemplate restTemplate = new RestTemplate();
	    loanInfo = restTemplate.postForObject(uri,loanInfo, LoanInfo.class);
		
		
		return service.calculateEMI(loanInfo);
	}
	
	

	

}
