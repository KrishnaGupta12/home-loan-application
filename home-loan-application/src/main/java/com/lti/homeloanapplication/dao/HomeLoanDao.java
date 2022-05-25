package com.lti.homeloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.homeloanapplication.entiti.Owner;

@Repository
public interface HomeLoanDao extends JpaRepository<Owner, Long> {

}
