package com.yk.web.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl {
	@Autowired
	UsersRepository usersRepository;
	
}
