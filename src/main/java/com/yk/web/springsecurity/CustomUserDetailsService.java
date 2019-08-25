package com.yk.web.springsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yk.web.users.Users;
import com.yk.web.users.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Let people login with either username or email
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> 
                        new UsernameNotFoundException(username+"님은 회원이 아닙니다.")
        );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("회원이 존재하지 않습니다.")
        );

        return UserPrincipal.create(user);
    }
}
