package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.LoanInfo;

public interface EMICalculatorService {
	
	public LoanInfo calculateInterestRate(LoanInfo loanInfo);
	
	public LoanInfo calculateEMI(LoanInfo loanInfo);

}
