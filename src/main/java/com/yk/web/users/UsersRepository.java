package com.yk.web.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUsername(String username);
	
	Optional<Users> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    @Modifying(clearAutomatically = true)
    @Query(value="update users u set u.password = ?, u.email = ? where u.username = ?", nativeQuery = true)
    void updateUserInfo(String password, String email, String username);
}
