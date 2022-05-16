package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.customexception.LoanException;
import com.lti.homeloanapplication.entity.Customer;
import com.lti.homeloanapplication.entity.Document;
import com.lti.homeloanapplication.entity.Loan;
import com.lti.homeloanapplication.entity.PropertyAndIncome;
import com.lti.homeloanapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerList(String username, HttpSession session) throws LoanException {
        return customerRepository.getCustomerList(username,session);
    }

    @Override
    public Customer addCustomerDetails(Customer customer, Loan loan, PropertyAndIncome propertyAndIncome, List<Document> document) throws LoanException {
        return customerRepository.addCustomerDetails(customer,loan,propertyAndIncome,document);
    }
}
