package com.isanka.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class CalanderDays {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="days")
	private Integer Id;
	 
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
}
