package com.lti.HomeLoanApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.HomeLoanApplication.Entity.Customer;
import com.lti.HomeLoanApplication.dao.CustomerRequest;
import com.lti.HomeLoanApplication.exception.CustomerNotFoundException;
import com.lti.HomeLoanApplication.repository.CustomerRespository;

@Service
public class CustomerService {

	@Autowired
	CustomerRespository customerRespository;

	public List<Customer> getAllCustomer() {
		return customerRespository.findAll();
	}

	public Customer getCustomer(Integer id) throws CustomerNotFoundException {

		return customerRespository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with given id " + id));

	}
	// add the customer in database
	public Customer saveCustomer(CustomerRequest customerRequest) {

		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setMobileNo(customerRequest.getMobileNo());
		customer.setGender(customerRequest.getGender());
		customer.setIncome(customerRequest.getIncome());
		customer.setLoanValue(customerRequest.getLoanValue());
		customer.setLocation(customerRequest.getLocation());
		customer.setEmployeementType(customerRequest.getEmployeementType());
		customer.setDateOfBirth(customerRequest.getDateOfBirth());
		customer.setAge(customerRequest.getAge());
		customer.setResident(customerRequest.getResident());
		customer.setCo_owner(customerRequest.getCo_owner());

		return customerRespository.save(customer);

	}

	/*
	 * public Customer getCustomer(Integer id) throws CustomerNotFoundException {
	 * 
	 * Customer customer = customerRespository.findById(id).orElseThrow();
	 * 
	 * System.out.println("customer=="+customer); if (customer != null) { return
	 * customer; } else { throw new
	 * CustomerNotFoundException("Customer not found with given id " + id); }
	 * 
	 * 
	 * 
	 * //return customerRespository.findById(id).get();
	 * 
	 * }
	 */

}
