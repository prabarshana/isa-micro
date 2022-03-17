package com.isanka.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isanka.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>  {

	@Query("SELECT case when count(1) > 0 then true else false end FROM Customer c where c.email = ?1")
	Boolean checkCustomerExists(String email);
}
