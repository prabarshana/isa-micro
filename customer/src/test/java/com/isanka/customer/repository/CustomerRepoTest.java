package com.isanka.customer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.isanka.customer.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
 
public class CustomerRepoTest {

	@Autowired
	private CustomerRepo customerRepo;
	
	@AfterEach
	void tearDown() {
		log.info("Cleaning Data..");
		customerRepo.deleteAll();
	}
	
	
	@Test
	public void test_CheckCustomerExists() throws Exception {

		//given
		Customer c = new Customer(
				null,
				"Isanka",
				"Patabandige",
				"prabarshana@gmail.com"
				);
		customerRepo.save(c);
		//when
		Boolean exists = customerRepo.checkCustomerExists("prabarshana@gmail.com");
		//then
		assertThat(exists).isTrue();	
	}
	
	
	@Test
	public void test_CheckCustomerNotExists() throws Exception {

		Boolean exists = customerRepo.checkCustomerExists("prabarshana@gmail.com");
		//then
		assertThat(exists).isFalse();	
	}
}