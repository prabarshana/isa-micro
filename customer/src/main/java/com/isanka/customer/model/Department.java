package com.isanka.customer.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "dept_deq")
	private Integer Id;
	
	@Column
	private String deptName;
	
	@OneToMany(mappedBy = "manager")
	private List<ManagerDepartment> mcust;
	
	@Column
	private Long number;
	
	@OneToMany(mappedBy = "department")
	private Set<DepartmentHolidays> holidays;
	
	
}
