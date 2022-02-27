package com.isanka.client.fraudclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRAUD")
public interface FraudClient {
	
	@GetMapping(path = "/api/check/{customerId}")
	public FraudCheckStatus check(@PathVariable(value = "customerId") Integer customerId);
	
}
