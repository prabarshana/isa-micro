package com.isanka.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isanka.customer.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>  {

}
