package com.isanka.amqp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqPropertyConfig {
	
	@Value("${rabbitmq.exchanges.internal}")
	private String exchange;

	@Value("${rabbitmq.queue.notification}")
	private String queue;

	@Value("${rabbitmq.routing-keys.internal-notification}")
	private String key;

	public String getExchange() {
		return exchange;
	}

	public String getQueue() {
		return queue;
	}

	public String getKey() {
		return key;
	}
}
