package com.lti.homeloanapplication.dto;
//RequestDTO for Calculating emi 
public class LoanAmountRequest {

	private String locality;
	private String house_condition;
	private double salary;
	private double duration;

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getHouse_condition() {
		return house_condition;
	}

	public void setHouse_condition(String house_condition) {
		this.house_condition = house_condition;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

}
