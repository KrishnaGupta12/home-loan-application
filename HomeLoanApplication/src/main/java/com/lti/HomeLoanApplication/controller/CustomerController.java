package com.lti.HomeLoanApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.HomeLoanApplication.Entity.Customer;
import com.lti.HomeLoanApplication.dao.CustomerRequest;
import com.lti.HomeLoanApplication.exception.CustomerNotFoundException;
import com.lti.HomeLoanApplication.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/test")
	public String test() {
		return "customer welcome";
	}

	/*
	 * @GetMapping(path="/cusDeatils",produces="application/json") public
	 * List<Customer> customerList(){ return customerService.getCustomer();
	 * 
	 * } //method=RequestMethod.POST //@Valid
	 * 
	 * @PostMapping( path="/addCustomer",produces="application/json",consumes
	 * =MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer
	 * customerDtl){
	 * 
	 * Customer cst= customerService.saveCustomer(customerDtl);
	 * 
	 * return new ResponseEntity<Customer>(cst,HttpStatus.CREATED);
	 * 
	 * 
	 * }
	 */

	@PostMapping("/sigUp")
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
		return new ResponseEntity<>(customerService.saveCustomer(customerRequest), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomer());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) throws CustomerNotFoundException {
		return ResponseEntity.ok(customerService.getCustomer(id));

	}

}
