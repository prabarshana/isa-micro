package com.isanka.notifications.service;

import org.springframework.stereotype.Component;

import com.isanka.client.notification.NotificationBody;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationService {

	
	
	public void emailMessage(NotificationBody body) {
		log.info("Sending email... {}", body);
		
	}
}
