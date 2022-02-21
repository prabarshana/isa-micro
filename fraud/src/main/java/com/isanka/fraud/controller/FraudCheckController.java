package com.isanka.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isanka.fraud.controller.model.FraudCheckStatus;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fraud/api/")
@Slf4j
public class FraudCheckController {

	@GetMapping(path = "/check/{customerId}")
	public FraudCheckStatus check(@PathVariable Integer customerId) {
		log.info("Checking fraud status {}", customerId);
		return FraudCheckStatus.builder().status(false).build();
	}

}
