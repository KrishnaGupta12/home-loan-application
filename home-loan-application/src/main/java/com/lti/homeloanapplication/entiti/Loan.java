package com.lti.homeloanapplication.entiti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lid;
	private String loanName;
	private double amount;
	private double roi;
	private int duration;
	private Double monthlyEmi;

	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Double getMonthlyEmi() {
		return monthlyEmi;
	}

	public void setMonthlyEmi(Double double1) {
		this.monthlyEmi = double1;
	}

	public Loan(long lid, String loanName, double amount, double roi, int duration, Double monthlyEmi) {
		super();
		this.lid = lid;
		this.loanName = loanName;
		this.amount = amount;
		this.roi = roi;
		this.duration = duration;
		this.monthlyEmi = monthlyEmi;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Loan [lid=" + lid + ", loanName=" + loanName + ", amount=" + amount + ", roi=" + roi + ", duration="
				+ duration + ", monthlyEmi=" + monthlyEmi + "]";
	}

}
