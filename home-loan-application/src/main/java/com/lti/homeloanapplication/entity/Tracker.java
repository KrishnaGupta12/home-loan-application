package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracker_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracker {
	@Id
	@Column(name="application_id")
	private Integer appId;
	private Integer status;

}

	
	


	