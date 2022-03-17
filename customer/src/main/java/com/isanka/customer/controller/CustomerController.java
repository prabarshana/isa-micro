package com.isanka.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.customer.exception.MyException;
import com.isanka.customer.model.Customer;
import com.isanka.customer.model.CustomerRegistrationRequest;
import com.isanka.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Secured("ROLE_admin")
	@PostMapping("register")
	public ResponseEntity<Customer> register(@RequestBody CustomerRegistrationRequest customerRequest) {
		Customer customer;
		try {
			customer = service.registerCustomer(customerRequest);
		} catch (Exception e) {
			throw new MyException(e.getMessage(), e.getCause());
		}
		log.info("Registering customer"+customerRequest);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping(path="customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId) {
		Customer customer =  service.getCustomer(customerId);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers =  service.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@PutMapping(path = "update/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody CustomerRegistrationRequest customerRequest) {
		Customer customer =  service.updateCustomer(customerId, customerRequest);
		return ResponseEntity.ok(customer);
		
	}
	
	@DeleteMapping(path = "delete/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId) {
		service.deleteCustomer(customerId);
		return ResponseEntity.ok("Deleted");
		
	}
	
}
