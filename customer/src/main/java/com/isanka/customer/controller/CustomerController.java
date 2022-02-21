package com.isanka.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.customer.model.CustomerRegistrationRequest;
import com.isanka.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/register")
	public void register(@RequestBody CustomerRegistrationRequest customerRequest) {
		service.registerCustomer(customerRequest);
		log.info("Registering customer"+customerRequest);
		
	}
	
	
}
