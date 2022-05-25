package com.lti.homeloanapplication.dto;
//This is the request DTO for saving the loan and insurance
public class AddLoanRequestDto {

	private long ownerId;
	private String loanName;
	private Double amount;
	private Double roi;
	private int duration;
	private Double monthlyEmi;
	private Double insuranceAmount;
	private boolean isinsuranceAccepted;
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
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
	public void setMonthlyEmi(Double monthlyEmi) {
		this.monthlyEmi = monthlyEmi;
	}
	public Double getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(Double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public boolean isIsinsuranceAccepted() {
		return isinsuranceAccepted;
	}
	public void setIsinsuranceAccepted(boolean isinsuranceAccepted) {
		this.isinsuranceAccepted = isinsuranceAccepted;
	}

}
