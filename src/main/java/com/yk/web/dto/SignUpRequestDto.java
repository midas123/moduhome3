package com.yk.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yk.web.users.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@NotBlank
//	@Size(min = 4, max = 40)
//	private String name;
//	
	@NotBlank
	@Size(min = 3, max = 15)
	private String username;
	
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 6, max = 20)
	private String password;
	
	public Users toEntity() {
		return Users.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.email(email)
				.build();
	}

}
