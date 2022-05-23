package com.lti.HomeLoanApplication.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.HomeLoanApplication.Entity.Customer;
import com.lti.HomeLoanApplication.Entity.Loan;
import com.lti.HomeLoanApplication.repository.CustomerRespository;
import com.lti.HomeLoanApplication.repository.LoanRespository;

@Service
public class LoanEligibilityCustomerService {
	private int  loanAmount;
	private double  rateOfInterest;
	private int  tenure;
	private double  emiAmount;
	
	private double  rateOfInterestPerMonth;
	private int  tenurePerMonth;
	
	
	SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	
	@Autowired
	LoanRespository loanRespository;
	
	@Autowired
	CustomerRespository customerRespository;
	
	// retrive the eligible customers for home loan
	public List<Customer> getEligibleCustomer() {
		List<Customer> eligibleCustomer =new ArrayList<Customer>();
				
		List<Customer> customersList= customerRespository.findAll();
		
		for(Customer customer:customersList) {
			if(customer.getAge()>=21 && (customer.getResident().equals("NRI")||customer.getResident().equals("India") )) {
				if(customer.getEmployeementType().equals("salaried") && customer.getIncome()>20000) {
					eligibleCustomer.add(customer);
				}
			}
			
		}
		return eligibleCustomer;
	}
	
	// calculate emi for eligible customer
	public List<Loan> calculateEmiByEligibleCustomer() {
		
		List<Customer> customersList=getEligibleCustomer();
		for(Customer customer:customersList) {
			Loan loan=new Loan();
			loan=	calculateEmi(customer);
			loanRespository.save(loan);
		}
		return loanRespository.findAll();
		
	}
	
	
	// calculate emi 
	public Loan calculateEmi(Customer customer) {
		Loan loan=new Loan();
		loanAmount=customer.getLoanValue();
		if(customer.getGender().equals("female") && customer.getCo_owner().equals("yes") && customer.getResident().equals("India")){
			rateOfInterest= 6.10;
			tenure=10;
			rateOfInterestPerMonth = rateOfInterest / (12 * 100);  
			tenurePerMonth = tenure * 12;
			emiAmount = (loanAmount * rateOfInterestPerMonth * Math.pow(1 +rateOfInterestPerMonth,tenurePerMonth)) / (Math.pow(1 + rateOfInterestPerMonth, tenurePerMonth) - 1);
	               
		
		}
		if(customer.getGender().equals("female") && customer.getCo_owner().equals("no") && customer.getResident().equals("India")){
			rateOfInterest= 6.45;
			tenure=10;
			rateOfInterestPerMonth = rateOfInterest / (12 * 100);  
			tenurePerMonth = tenure * 12;
			emiAmount = (loanAmount * rateOfInterestPerMonth * Math.pow(1 +rateOfInterestPerMonth,tenurePerMonth)) / (Math.pow(1 + rateOfInterestPerMonth, tenurePerMonth) - 1);
		}
		if(customer.getGender().equals("male") && customer.getCo_owner().equals("yes") && customer.getResident().equals("India")){
			rateOfInterest= 7.15;
			tenure=10;
			rateOfInterestPerMonth = rateOfInterest / (12 * 100);  
			tenurePerMonth = tenure * 12;
			emiAmount = (loanAmount * rateOfInterestPerMonth * Math.pow(1 +rateOfInterestPerMonth,tenurePerMonth)) / (Math.pow(1 + rateOfInterestPerMonth, tenurePerMonth) - 1);
		}
		
		if(customer.getGender().equals("male") && customer.getCo_owner().equals("no") && customer.getResident().equals("India")){
			
			rateOfInterest= 7.25;
			tenure=10;
			rateOfInterestPerMonth = rateOfInterest / (12 * 100);  
			tenurePerMonth = tenure * 12;
			emiAmount = (loanAmount * rateOfInterestPerMonth * Math.pow(1 +rateOfInterestPerMonth,tenurePerMonth)) / (Math.pow(1 + rateOfInterestPerMonth, tenurePerMonth) - 1);
			
		
		}
		loan.setCustomerId(customer.getId());
		loan.setLoanAmount(customer.getLoanValue());
		loan.setInterestRate(rateOfInterest);
		loan.setTenure(tenure);
		loan.setEmiAmount(emiAmount);
		
		return loan;
		
	}
	
	public int calculateAge(Date dateOfBirth) {
		String strDate = dateFormat.format(dateOfBirth);  
		LocalDate dob = LocalDate.parse(strDate);  
		LocalDate curDate = LocalDate.now();
		return Period.between(dob, curDate).getYears();
	}
	
	
}
