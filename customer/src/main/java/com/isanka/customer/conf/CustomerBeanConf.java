package com.isanka.customer.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerBeanConf {

	@Bean
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}
	
	
	
}
