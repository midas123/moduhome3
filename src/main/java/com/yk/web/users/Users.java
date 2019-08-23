package com.yk.web.users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

	@Builder
	public Users(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public void setPassword(String encode) {
		this.password = encode;
	}

	public void setRoles(Set<Roles> singleton) {
		this.roles = singleton;
	}

}
