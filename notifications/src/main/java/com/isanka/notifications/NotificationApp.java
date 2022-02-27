package com.isanka.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "com.isanka.amqp", "com.isanka.notifications" })
@EnableEurekaClient
public class NotificationApp {
	public static void main(String[] args) {
		SpringApplication.run(NotificationApp.class, args);
	}

}
