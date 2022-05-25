package com.lti.homeloanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.homeloanapplication.entiti.Insurance;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Long> {

}
