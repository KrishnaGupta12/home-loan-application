package com.lti.homeloanapplication.service;

import com.lti.homeloanapplication.entity.Customer;
import com.lti.homeloanapplication.entity.Document;
import com.lti.homeloanapplication.entity.Loan;
import com.lti.homeloanapplication.entity.PropertyAndIncome;
import com.lti.homeloanapplication.customexception.LoanException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface CustomerService  {

    public List<Customer> getCustomerList(String username, HttpSession session) throws LoanException;
    public Customer addCustomerDetails(Customer customer, Loan loan, PropertyAndIncome propertyAndIncome, List<Document> document)throws LoanException;



}
