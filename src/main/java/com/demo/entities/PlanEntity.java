package com.demo.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Plan")
@Data
public class PlanEntity {

	@Id
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name = "HOLDER_NAME")
	private String holderName;
	
	@Column(name = "HOLDER_SSN")
	private Integer holderSsn;
	
	@Column(name = "PLAN_STATUS")
	private String planStatus;

}
