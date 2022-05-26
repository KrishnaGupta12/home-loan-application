package com.homeloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.dao.PaymentDao;
import com.homeloan.model.Payment;
import com.homeloan.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao employeeDao;

	@Override
	public void insertPaymentDetails(Payment payment) {
		employeeDao.insertPaymentDetails(payment);
	}

}