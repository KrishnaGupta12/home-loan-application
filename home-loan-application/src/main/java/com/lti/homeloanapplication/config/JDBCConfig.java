package com.lti.homeloanapplication.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
public class JDBCConfig {

	@Value("${spring.datasource.url}")
	private String url;
		
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String passWord;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWord);
			
		return dataSource;
		
	}
	
	
	@Bean 
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
	
}
