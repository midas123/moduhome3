package com.yk.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthResponseDto {
	private String accessToken;
    private String tokenType = "Bearer";
    
    public JwtAuthResponseDto(String token) {
    	this.accessToken = token;
    }
}
