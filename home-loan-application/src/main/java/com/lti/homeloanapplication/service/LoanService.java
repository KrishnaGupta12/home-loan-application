package com.lti.homeloanapplication.service;

import java.util.List;

import com.lti.homeloanapplication.dto.AddLoanRequestDto;
import com.lti.homeloanapplication.dto.LoanAmountRequest;
import com.lti.homeloanapplication.dto.LoanAmountResponse;
import com.lti.homeloanapplication.entiti.Loan;
import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.MyException;

public interface LoanService {

	public Owner addLoan(AddLoanRequestDto addLoanRequestDto) throws MyException;

	public List<Loan> getLoan();

	public LoanAmountResponse calculateLoan(LoanAmountRequest loanAmountRequest);
}
