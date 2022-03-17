package com.isanka.client.fraudclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FRAUD", path = "/api/v1/check")
public interface FraudClient {
	
	@GetMapping(path = "{customerId}")
	public FraudCheckStatus check(@PathVariable(value = "customerId") Integer customerId);
	
}
