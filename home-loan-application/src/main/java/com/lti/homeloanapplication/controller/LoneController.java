package com.lti.homeloanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.homeloanapplication.dto.AddLoanRequestDto;
import com.lti.homeloanapplication.dto.LoanAmountRequest;
import com.lti.homeloanapplication.dto.LoanAmountResponse;
import com.lti.homeloanapplication.entiti.Loan;
import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.MyException;
import com.lti.homeloanapplication.service.LoanService;

@RestController
public class LoneController {

	@Autowired
	private LoanService loanService;

//This is for saving Loan and insurance details in DB
	@PostMapping("/loan")
	public Owner addLoan(@RequestBody AddLoanRequestDto addLoanRequestDto) throws MyException {

		return loanService.addLoan(addLoanRequestDto);
	}

//This API is for calculating the Amount based on the user's input.
	@PostMapping("/amount")
	public LoanAmountResponse calculateAmount(@RequestBody LoanAmountRequest loanAmountRequest) {

		return loanService.calculateLoan(loanAmountRequest);
	}

	@GetMapping("loan")
	public List<Loan> getLoan() {
		return null;
	}

}
