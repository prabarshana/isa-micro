package com.isanka.customer.service;

import com.isanka.customer.model.Customer;
import com.isanka.customer.model.CustomerRegistrationRequest;

public interface CustomerService {
	Customer registerCustomer(CustomerRegistrationRequest request);
}
