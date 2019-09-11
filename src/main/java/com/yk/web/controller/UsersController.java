package com.yk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.web.dto.ApiResponseDto;
import com.yk.web.dto.SignUpRequestDto;
import com.yk.web.exception.AppException;
import com.yk.web.users.Users;
import com.yk.web.users.UsersRepository;
import com.yk.web.users.UsersServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api-user")
@RestController
public class UsersController {
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UsersServiceImpl usersServiceImpl;
	
	@PutMapping("/user/{username}")
	public ResponseEntity<?> modifyUserInfo(@PathVariable String username, @RequestBody SignUpRequestDto dto ) {
		dto.setUsername(username);
		usersServiceImpl.updateUserInfo(dto);
		return ResponseEntity.ok(new ApiResponseDto(true, "회원 정보가 수정되었습니다."));
	}
	
	@GetMapping("/user/{username}")
	public Users getUserInfo(@PathVariable String username) {	
		System.out.println("getUserInfo: "+usersRepository.findByUsername(username));
		return usersRepository.findByUsername(username).orElseThrow(()-> new AppException("회원 정보가 존재하지 않습니다."));
	}

}
