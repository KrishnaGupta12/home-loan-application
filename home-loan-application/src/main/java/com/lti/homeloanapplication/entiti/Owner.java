package com.lti.homeloanapplication.entiti;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
@Entity
public class Owner implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	//@NotEmpty(message = "Cannot be empty")
	private String name;
	private String address;
	private Double salary;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId", referencedColumnName = "lid")
	private Loan loan;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurId", referencedColumnName = "insurId")
	private Insurance insurance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Owner(long id, String name, String address, Double salary, Loan loan, Insurance insurance) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.loan = loan;
		this.insurance = insurance;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", loan=" + loan
				+ ", insurance=" + insurance + "]";
	}
}
