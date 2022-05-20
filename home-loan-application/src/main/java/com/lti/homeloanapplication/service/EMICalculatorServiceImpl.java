package com.lti.homeloanapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.lti.homeloanapplication.entity.LoanInfo;

@Service
public class EMICalculatorServiceImpl implements EMICalculatorService {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	
	
	@Override
	public LoanInfo calculateInterestRate(LoanInfo loanInfo) {
		
		
		String query =" select * from public.\"InterestRates\" ";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(query);
		
		int creditScore=loanInfo.getCreditScore();
		
		for (Map<String, Object> map : list) {
		  	int credit_min= (int) map.get("Credit_Min");
			int credit_max= (int) map.get("Credit_Max");
			
			
			if(creditScore > credit_min  && creditScore < credit_max)
			{
				if(loanInfo.getSalariedOrSelfEmployed())
				{
					loanInfo.setInterestRate((double) map.get("InterestRateForSalaried"));	
					//System.out.println((double) map.get("InterestRateForSalaried"));
				}
				else
				{
					loanInfo.setInterestRate((double) map.get("InterestRateForSelfEmployed"));
					//System.out.println((double) map.get("InterestRateForSelfEmployed"));
				}
									 
									 
								 
				
			}
				
			
		}


		 
		
//			System.out.println("Inside Service layer");
//			
//			int creditScore1 =loanInfo.getCreditScore();
//			
//			if(loanInfo.getSalariedOrSelfEmployed())
//			{
//				if(creditScore1 <701)
//					loanInfo.setInterestRate(8.10);
//				else if(creditScore1>701 && creditScore1<726)
//					loanInfo.setInterestRate(7.10);
//				else if(creditScore1>726 && creditScore1<751)
//					loanInfo.setInterestRate(7.00);
//				else if(creditScore1>751 && creditScore1<771)
//					loanInfo.setInterestRate(6.85);
//				else if(creditScore1>771 && creditScore1<800)
//					loanInfo.setInterestRate(6.75);
//				else if(creditScore1>800)
//					loanInfo.setInterestRate(6.75);
//				
//				
//			}
//			else
//			{
//				if(creditScore1 <701)
//					loanInfo.setInterestRate(8.20);
//				else if(creditScore1>701 && creditScore1<726)
//					loanInfo.setInterestRate(7.20);
//				else if(creditScore1>726 && creditScore1<751)
//					loanInfo.setInterestRate(7.10);
//				else if(creditScore1>751 && creditScore1<771)
//					loanInfo.setInterestRate(6.95);
//				else if(creditScore1>771 && creditScore1<800)
//					loanInfo.setInterestRate(6.85);
//				else if(creditScore1>800)
//					loanInfo.setInterestRate(6.85);
//				
//			}
			return loanInfo;
			
		
	}

	@Override
	public LoanInfo calculateEMI(LoanInfo loanInfo) {
		// TODO Auto-generated method stub
		long P=loanInfo.getLoanAmount();// P is Loan amount
		double R=loanInfo.getInterestRate();// R is rate of interest
		double N=loanInfo.getTenureInYears() * 12; //N is Tenure in months
		
		R=R/12/100;//monthly interest
		
//		System.out.println("Loan amount: "+P);
//		System.out.println("Interest rate: "+R);
//		System.out.println("Loan tenure: "+N);
//		
//		
		
		
		long EMI = (long) ((P*R*Math.pow(1+R,N))/(Math.pow(1+R,N) -1));
		loanInfo.setEMI(EMI);
		
		return loanInfo;
	}

	

}
