package com.isanka.notifications.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isanka.client.notification.NotificationBody;
import com.isanka.notifications.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMqConsumer {

	@Autowired
	private NotificationService notificationService;

	@RabbitListener(queues = { "${rabbitmq.queue.notification}" })
	public void consume(NotificationBody body) {
		log.info("Recieved from the queue, Message is {}", body);
		notificationService.emailMessage(body);
	}

}
