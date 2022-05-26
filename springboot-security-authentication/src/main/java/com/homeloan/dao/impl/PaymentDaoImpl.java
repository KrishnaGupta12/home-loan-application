package com.homeloan.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.homeloan.dao.PaymentDao;
import com.homeloan.model.Payment;

@Repository
public class PaymentDaoImpl extends JdbcDaoSupport implements PaymentDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertPaymentDetails(Payment payment) {
		String sql = "INSERT INTO payment " +
				"(paymentId, paymentType) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				payment.getPaymentId(), payment.getPaymentType()
		});
	}
}