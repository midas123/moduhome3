package com.yk.web.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;

	@Builder
	public Users(long user_id, String username, String password, String email) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

}
