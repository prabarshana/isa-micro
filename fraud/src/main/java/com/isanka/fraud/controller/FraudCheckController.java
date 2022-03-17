package com.isanka.fraud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.client.fraudclient.FraudCheckStatus;
import com.isanka.fraud.service.FraudCheckService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/check")
public class FraudCheckController {
	
	@Autowired
	private FraudCheckService service;

	@GetMapping(path = "{customerId}")
	public FraudCheckStatus check(@PathVariable("customerId") Integer customerId) {
		log.info("Checking fraud status {}", customerId);
		return service.check(customerId);
	}

}
