package com.yk.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDto {
	private Boolean success;
	private String message;
	 
	@Builder 
	public ApiResponseDto(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	 
	 
}
