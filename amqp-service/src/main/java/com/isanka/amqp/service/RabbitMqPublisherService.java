package com.isanka.amqp.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMqPublisherService {
	@Autowired
	private AmqpTemplate rabbitMqTemplate;

	public void publish(Object message, String exchange, String routingKey) {

		log.info("Publishing message {} to exchange {} using key {}", message, exchange, routingKey);
		rabbitMqTemplate.convertAndSend(exchange, routingKey, message);
		log.info("Publishing message {} to exchange {} using key {}", message, exchange, routingKey);
	}

}
