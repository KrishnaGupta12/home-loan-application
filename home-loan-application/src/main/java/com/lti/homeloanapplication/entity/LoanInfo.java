package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfo {
		
	//These are inputs from user
		private long loanAmount;
		private int tenureInYears;
		private int creditScore;
		private Boolean salariedOrSelfEmployed;
		
	//This will be set by the system 
		private double interestRate;
		private long EMI;
		
		
		public long getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(long loanAmount) {
			this.loanAmount = loanAmount;
		}
		public int getTenureInYears() {
			return tenureInYears;
		}
		public void setTenureInYears(int tenureInYears) {
			this.tenureInYears = tenureInYears;
		}
		public int getCreditScore() {
			return creditScore;
		}
		public void setCreditScore(int creditScore) {
			this.creditScore = creditScore;
		}
		public Boolean getSalariedOrSelfEmployed() {
			return salariedOrSelfEmployed;
		}
		public void setSalariedOrSelfEmployed(Boolean salariedOrSelfEmployed) {
			this.salariedOrSelfEmployed = salariedOrSelfEmployed;
		}
		public double getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}
		public double getEMI() {
			return EMI;
		}
		public void setEMI(long eMI) {
			EMI = eMI;
		}
		
		
		
		
		
		
		
}

