package com.lti.HomeLoanApplication.dao;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor(staticName ="build")
//@NoArgsConstructor
public class CustomerRequest {
	private Integer id;
	@NotNull(message = "Name should not be null")
	@NotBlank(message = " Name should not be blank")
	private String name;

	@NotNull(message = "Email should not be null")
	@NotBlank(message = " Email should not be blank")
	@Email(message = "email should be a valid email")
	private String emailId;
	
	@NotBlank(message = "Mobile should not be blank")
	@Pattern(regexp = "^\\d{10}$")
	private String mobileNo;
	
	@NotNull(message = "Gender should not be null")
	@NotBlank(message = "Gender should not be blank")
	private String gender;
	
	
	private Date dateOfBirth;
	
	@NotNull(message = "Location should not be null")
	@NotBlank(message = " Location should not be blank")
	private String location;

	@NotNull(message = "Employeement Type should not be null")
	@NotBlank(message = " Employeement Type should not be blank")
	private String employeementType;

	private Integer income;

	private Integer loanValue;
	private Integer age;
	private String resident;
	private String co_owner;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeementType() {
		return employeementType;
	}

	public void setEmployeementType(String employeementType) {
		this.employeementType = employeementType;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(Integer loanValue) {
		this.loanValue = loanValue;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getCo_owner() {
		return co_owner;
	}

	public void setCo_owner(String co_owner) {
		this.co_owner = co_owner;
	}

}
