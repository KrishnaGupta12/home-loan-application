package com.lti.HomeLoanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.HomeLoanApplication.Entity.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Integer> {

	// List<Customer> findAll();
	// Customer save(CustomerRequest customerRequest);
	Customer findById(int custId);

}
