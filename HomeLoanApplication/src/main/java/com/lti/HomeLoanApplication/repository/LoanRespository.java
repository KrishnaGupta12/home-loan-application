package com.lti.HomeLoanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.HomeLoanApplication.Entity.Loan;

@Repository
public interface LoanRespository extends JpaRepository<Loan,Integer>{

}
