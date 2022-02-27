package com.isanka.notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.client.notification.NotificationBody;
import com.isanka.notifications.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService service;


	@PostMapping(path = "/email")
	public ResponseEntity<String> sendEmail(@RequestBody NotificationBody body) {
		log.info("Sending email notification {} ", body);
		service.emailMessage(body);
		return ResponseEntity.ok("Email Sent");
	}
	
}
