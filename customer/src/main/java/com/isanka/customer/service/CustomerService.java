package com.isanka.customer.service;

import java.util.List;

import com.isanka.customer.model.Customer;
import com.isanka.customer.model.CustomerRegistrationRequest;

public interface CustomerService {
	Customer registerCustomer(CustomerRegistrationRequest request);
	
	Customer getCustomer(Integer CustomerId);
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(Integer CustomerId,CustomerRegistrationRequest customerRequest);
	
	void deleteCustomer(Integer CustomerId);
}
