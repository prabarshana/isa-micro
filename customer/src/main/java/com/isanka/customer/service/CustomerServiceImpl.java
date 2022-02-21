package com.isanka.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.isanka.customer.model.Customer;
import com.isanka.customer.model.CustomerRegistrationRequest;
import com.isanka.customer.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo dao;
	
	@Autowired
	private RestTemplate template;

	public Customer registerCustomer(CustomerRegistrationRequest request) {

		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email()).build();
		
		dao.saveAndFlush(customer);
		
		ResponseEntity<String> result = template.getForEntity("http://localhost:8081/fraud/api/check/{customerId}", String.class, customer.getId());
		log.info(result.getBody());
		
		return customer;
		
		
		
		
		

	}

}
