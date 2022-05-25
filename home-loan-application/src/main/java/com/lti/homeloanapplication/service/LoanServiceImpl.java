package com.lti.homeloanapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.homeloanapplication.dao.HomeLoanDao;
import com.lti.homeloanapplication.dao.InsuranceDao;
import com.lti.homeloanapplication.dao.LoanDao;
import com.lti.homeloanapplication.dto.AddLoanRequestDto;
import com.lti.homeloanapplication.dto.LoanAmountRequest;
import com.lti.homeloanapplication.dto.LoanAmountResponse;
import com.lti.homeloanapplication.entiti.Insurance;
import com.lti.homeloanapplication.entiti.Loan;
import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.MyException;

@Service

public class LoanServiceImpl implements LoanService {
	// @Value(value = "roi")
	// private String rateOfInterest;
	@Autowired
	private LoanDao loanDao;
	@Autowired
	private HomeLoanDao homeLoanDao;
	@Autowired
	private InsuranceDao insuranceDao;

	@Override // Save loan
	public Owner addLoan(AddLoanRequestDto addLoanRequestDto) throws MyException {
		if (addLoanRequestDto.getLoanName().isEmpty()) {
			throw new MyException();
		}
		if ((addLoanRequestDto.getAmount()) == null || addLoanRequestDto.getMonthlyEmi() == null) {
			throw new MyException();
		}
		Loan loan = new Loan();

		// if insurance is selected insurance amount is selected from the total amount
		if (addLoanRequestDto.isIsinsuranceAccepted()) {
			loan.setAmount(addLoanRequestDto.getAmount() - addLoanRequestDto.getInsuranceAmount());
		} else {
			loan.setAmount(addLoanRequestDto.getAmount());
		}

		loan.setDuration(addLoanRequestDto.getDuration());
		loan.setMonthlyEmi(addLoanRequestDto.getMonthlyEmi());
		loan.setRoi(addLoanRequestDto.getRoi());
		loan.setLoanName(addLoanRequestDto.getLoanName());

		Loan savedLoan = loanDao.save(loan);
		long ownId = addLoanRequestDto.getOwnerId();
		Optional<Owner> optOwner = homeLoanDao.findById(ownId);
		Owner owner = optOwner.get();
		owner.setLoan(savedLoan);
		Insurance savedInsurance = new Insurance();

		if (addLoanRequestDto.isIsinsuranceAccepted()) {
			Insurance insur = new Insurance();
			insur.setInsuranceAmount(addLoanRequestDto.getInsuranceAmount());
			insur.setIsinsuranceAccepted(true);
			savedInsurance = insuranceDao.save(insur);
		}
		owner.setInsurance(savedInsurance);
		return homeLoanDao.save(owner);
	}

	@Override
	public List<Loan> getLoan() {
		List<Loan> li;
		li = loanDao.findAll();
		return li;
	}

	private int getCondition(String houseCondition, int amount) {

		if (houseCondition.equals("poor")) {
			return amount - 400000;

		} else if (houseCondition.equals("average")) {
			return amount - 200000;
		} else {
			return amount;
		}
	}

	private LoanAmountResponse emiCalcul(double duration, int amount, double insuranceAmount) {
		LoanAmountResponse response = new LoanAmountResponse();
		// Calculating the EMI & Insurance on certain conditions
		double roi = 14.0 / (12 * 100);
		duration = duration * 12;
		double emi = (amount * roi * Math.pow(1 + roi, duration)) / (Math.pow(1 + roi, duration) - 1);
		if (amount > 1000000) {
			insuranceAmount = (amount * 10) / 100;
		} else {
			insuranceAmount = (amount * 6) / 100;
		}
		response.setAmount(amount);
		response.setDuration(duration);
		response.setMonthly_emi(emi);
		response.setRoi(14.0);
		response.setInsuranceAmount(insuranceAmount);
		return response;
	}

	@Override
	public LoanAmountResponse calculateLoan(LoanAmountRequest loanAmountRequest) {
		LoanAmountResponse response = new LoanAmountResponse();
		// Amount Logic calculate amount on the given criteria
		int amount;
		double insuranceAmount = 0;
		if (loanAmountRequest.getSalary() > 50000) {
			if (loanAmountRequest.getLocality().equals("Village")) {
				amount = getCondition(loanAmountRequest.getHouse_condition(), 1000000);
			} else {
				amount = getCondition(loanAmountRequest.getHouse_condition(), 2000000);
			}
		} else {
			return null;
		}

		response = emiCalcul(loanAmountRequest.getDuration(), amount, insuranceAmount);
		response.setSalary(loanAmountRequest.getSalary());
		return response;
	}

}
