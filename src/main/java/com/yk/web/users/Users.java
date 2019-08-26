package com.yk.web.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.yk.web.order.Orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {
	@Id
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
    
    @OneToMany
    List<Orders> orders = new ArrayList<>();
    
	@Builder
	public Users(String username, String password, String email, Long user_id) {
		this.user_id = user_id;
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
