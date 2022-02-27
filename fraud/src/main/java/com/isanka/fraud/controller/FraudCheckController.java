package com.isanka.fraud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.client.fraudclient.FraudCheckStatus;
import com.isanka.fraud.service.FraudCheckService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FraudCheckController {
	
	@Autowired
	private FraudCheckService service;

	@GetMapping(path = "/api/check/{customerId}")
	public FraudCheckStatus check(@PathVariable Integer customerId) {
		log.info("Checking fraud status {}", customerId);
		return service.check(customerId);
	}

}
