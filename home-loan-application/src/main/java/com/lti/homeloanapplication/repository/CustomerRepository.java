package com.lti.homeloanapplication.repository;

import com.lti.homeloanapplication.entity.Customer;
import com.lti.homeloanapplication.entity.Document;
import com.lti.homeloanapplication.entity.Loan;
import com.lti.homeloanapplication.entity.PropertyAndIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer addCustomerDetails(Customer customer, Loan loan, PropertyAndIncome propertyAndIncome, List<Document> document);

    List<Customer> getCustomerList(String username, HttpSession session);
}
