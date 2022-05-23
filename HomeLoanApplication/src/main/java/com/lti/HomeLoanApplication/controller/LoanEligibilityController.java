package com.lti.HomeLoanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.HomeLoanApplication.Entity.Customer;
import com.lti.HomeLoanApplication.service.LoanEligibilityCustomerService;

@RestController
@RequestMapping("/loanEligible")
public class LoanEligibilityController {

	@Autowired
	LoanEligibilityCustomerService loanElgCustService;

	@GetMapping("/test")
	public String test() {
		return "loan welcome";
	}

	@GetMapping("/eligibleCustomers")
	public ResponseEntity<List<Customer>> showEligibleCustomer() {
		return ResponseEntity.ok(loanElgCustService.getEligibleCustomer());

	}
}
