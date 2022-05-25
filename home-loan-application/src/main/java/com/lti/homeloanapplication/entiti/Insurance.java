package com.lti.homeloanapplication.entiti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long insurId;
	private double insuranceAmount;
	private boolean isinsuranceAccepted;

	public long getInsurId() {
		return insurId;
	}

	public void setInsurId(long insurId) {
		this.insurId = insurId;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public boolean isIsinsuranceAccepted() {
		return isinsuranceAccepted;
	}

	public void setIsinsuranceAccepted(boolean isinsuranceAccepted) {
		this.isinsuranceAccepted = isinsuranceAccepted;
	}

}
