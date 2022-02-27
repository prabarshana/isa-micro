package com.isanka.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONS", path = "/notification")
public interface NotificationClient {
	@PostMapping(path = "/email")
	public ResponseEntity<String> sendEmail(@RequestBody NotificationBody body);

}
