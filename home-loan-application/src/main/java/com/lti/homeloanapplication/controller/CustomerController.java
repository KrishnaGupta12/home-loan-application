package com.lti.homeloanapplication.controller;

import com.lti.homeloanapplication.entity.Customer;
import com.lti.homeloanapplication.repository.CustomerRepository;
import com.lti.homeloanapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


}
