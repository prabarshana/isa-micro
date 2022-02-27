package com.isanka.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

	@Autowired
	private RabbitMqPropertyConfig config;

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(config.getExchange());
	}

	@Bean
	public Queue msgQueue() {
		return new Queue(config.getQueue());
	}

	@Bean
	public Binding exchangeToQueueBinding() {
		return BindingBuilder.bind(msgQueue()).to(topicExchange()).with(config.getKey());
	}

}
