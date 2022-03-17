package com.isanka.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ManagerDepartment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Manager manager;
	
	@ManyToOne
	private Department department;

}
