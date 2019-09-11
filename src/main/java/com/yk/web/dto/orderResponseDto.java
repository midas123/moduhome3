package com.yk.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class orderResponseDto {
	private Boolean success;
	private String ordercode;
	private String message;
	
	@Builder
	public orderResponseDto(String ordercode, String message, Boolean success) {
		this.ordercode = ordercode;
		this.message = message;
		this.success = success;
	}
	
}
