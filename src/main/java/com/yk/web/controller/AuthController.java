package com.yk.web.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yk.web.dto.ApiResponseDto;
import com.yk.web.dto.JwtAuthResponseDto;
import com.yk.web.dto.LoginRequestDto;
import com.yk.web.dto.SignUpRequestDto;
import com.yk.web.exception.AppException;
import com.yk.web.springsecurity.JwtTokenProvider;
import com.yk.web.users.RoleName;
import com.yk.web.users.Roles;
import com.yk.web.users.RolesRepository;
import com.yk.web.users.Users;
import com.yk.web.users.UsersRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDto dto) {
	
	    Authentication authentication = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken( dto.getUsername(), dto.getPassword())
	    );
	
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	
	    String jwt = tokenProvider.generateToken(authentication);
	    return ResponseEntity.ok(new JwtAuthResponseDto(jwt));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestDto signUpRequest) {
	    if(usersRepository.existsByUsername(signUpRequest.getUsername())) {
	        return new ResponseEntity(new ApiResponseDto(false, "이미 사용 중인 사용자 이름 입니다."),
	            HttpStatus.BAD_REQUEST);
	    }
	
		if(usersRepository.existsByEmail(signUpRequest.getEmail())) {
		    return new ResponseEntity(new ApiResponseDto(false, "이미 사용 중인 이메일 입니다."),
		            HttpStatus.BAD_REQUEST);
		}
	
		Users user = signUpRequest.toEntity();
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		Roles userRole = rolesRepository.findByName(RoleName.ROLE_USER)
		        .orElseThrow(() -> new AppException("사용자 등급을 설정해주세요."));
		
		user.setRoles(Collections.singleton(userRole)); 
		Users result = usersRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
		        .fromCurrentContextPath().path("/api/users/{username}")
		        .buildAndExpand(result.getUsername()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponseDto(true, "회원 가입이 안료되었습니다."));
	}
}
