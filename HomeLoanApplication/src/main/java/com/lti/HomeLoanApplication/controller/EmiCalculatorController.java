package com.lti.HomeLoanApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.HomeLoanApplication.Entity.Loan;
import com.lti.HomeLoanApplication.service.LoanEligibilityCustomerService;

@RestController
@RequestMapping("/emi")
public class EmiCalculatorController {
	@Autowired
	LoanEligibilityCustomerService loanElgCustService;

	@GetMapping("/test")
	public String test() {
		return "Welcome emi Controller";
	}

	@GetMapping("/emiCalculate")
	public ResponseEntity<List<Loan>> showLoanDetails() {
		return ResponseEntity.ok(loanElgCustService.calculateEmiByEligibleCustomer());
	}

}
