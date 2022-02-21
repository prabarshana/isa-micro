package com.isanka.fraud.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudCheckStatus {
	private Boolean status;
}
