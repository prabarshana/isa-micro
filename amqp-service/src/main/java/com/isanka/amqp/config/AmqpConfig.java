package com.isanka.amqp.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmqpConfig {

	@Autowired
	private ConnectionFactory connectionFactory;
	
	
	@Bean
	@Primary
	public AmqpTemplate amqpTemplate() {
		RabbitTemplate template = new RabbitTemplate();
		template.setConnectionFactory(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
	}
	
	@Bean
	public MessageConverter messageConverter () {
		MessageConverter converter = new Jackson2JsonMessageConverter();
		return converter;
	}
	
	@Bean
	public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory () {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(messageConverter());
		return factory;
	}
}
