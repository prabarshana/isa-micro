package com.isanka.fraud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isanka.amqp.config.RabbitMqPropertyConfig;
import com.isanka.amqp.service.RabbitMqPublisherService;
import com.isanka.client.fraudclient.FraudCheckStatus;
import com.isanka.client.notification.NotificationBody;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FraudCheckService {

	@Autowired
	private RabbitMqPublisherService emailQueueService;
	
	@Autowired
	private RabbitMqPropertyConfig rabbitMqPropertyConfig;
	
	
	public FraudCheckStatus check(Integer customerId) { 
		log.info("Checking fraud status {}", customerId);
		
		NotificationBody body = NotificationBody.builder()
		.body("Checking fraud status for customer "+customerId)
		.header("Fraud Check notification")
		.address("fraud@checker.com")
		.build();
		
		emailQueueService.publish(body, rabbitMqPropertyConfig.getExchange(), rabbitMqPropertyConfig.getKey());
		
		return FraudCheckStatus.builder()
				.status(false)
				.checkedDate(new Date())
				.build();
		
		
	}
	
}
