package com.lti.homeloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.homeloanapplication.entiti.Loan;

@Repository
public interface LoanDao extends JpaRepository<Loan, Long> {

}
