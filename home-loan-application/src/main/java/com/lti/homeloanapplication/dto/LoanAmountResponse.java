package com.lti.homeloanapplication.dto;
//Response of the loan save api
public class LoanAmountResponse {
	private double monthly_emi;
	private double salary;
	private double amount;
	private double duration;
	private double roi;
	private double insuranceAmount;

	public double getMonthly_emi() {
		return monthly_emi;
	}

	public void setMonthly_emi(double monthly_emi) {
		this.monthly_emi = monthly_emi;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

}
