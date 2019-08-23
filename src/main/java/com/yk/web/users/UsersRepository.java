package com.yk.web.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUsername(String username);
	
	Optional<Users> findByEmail(String email);

    //Optional<User> findByUsernameOrEmail(String username, String email);

    //List<Users> findByUser_idIn(List<Long> userIds);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
