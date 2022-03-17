package com.isanka.customer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	
	@OneToMany(mappedBy = "department")
	private List<ManagerDepartment> mcust;
}
