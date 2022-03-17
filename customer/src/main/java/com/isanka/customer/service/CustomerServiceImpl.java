package com.isanka.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isanka.amqp.config.RabbitMqPropertyConfig;
import com.isanka.amqp.service.RabbitMqPublisherService;
import com.isanka.client.fraudclient.FraudCheckStatus;
import com.isanka.client.fraudclient.FraudClient;
import com.isanka.client.notification.NotificationBody;
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
	private FraudClient fraudService;
	
	@Autowired
	private RabbitMqPublisherService emailQueue;
	
	@Autowired
	private RabbitMqPropertyConfig config;
	
	public Customer registerCustomer(CustomerRegistrationRequest request) {

		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email()).build();
		
		dao.saveAndFlush(customer);
		
		
		FraudCheckStatus status =  fraudService.check(customer.getId());
		
		NotificationBody body = NotificationBody.builder()
		.body("Registering customer")
		.header("Client Registration "+request.toString())
		.address("support@client.com")
		.build();
		
		
		emailQueue.publish(body, config.getExchange(), config.getKey());
		
		log.info(status.toString());
		
		return customer;
	}

	@Override
	public Customer getCustomer(Integer CustomerId) {
		return dao.findById(CustomerId).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return dao.findAll();
	}

	@Override
	public Customer updateCustomer(Integer CustomerId, CustomerRegistrationRequest request) {

		Customer customer = Customer.builder()
				.id(CustomerId)
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email()).build();
		
		return dao.save(customer);
		
	}

	@Override
	public void deleteCustomer(Integer CustomerId) {
		dao.deleteById(CustomerId);
	}
	

	

}
