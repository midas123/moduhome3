package com.yk.web.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.web.dto.SignUpRequestDto;

@Service
@Transactional
public class UsersServiceImpl {
	@Autowired
	UsersRepository usersRepository;
	
	public void updateUserInfo(SignUpRequestDto dto) {
		System.out.println("update: "+ dto.getEmail());
		usersRepository.updateUserInfo(dto.getPassword(), dto.getEmail(), dto.getUsername());
	}
	
}
