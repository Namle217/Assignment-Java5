package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Users")
public class User {
	@Id
	@Column( name = "USERNAME", nullable = false)
	private String username;
	@Column( name = "PASSWORD", nullable = false)
	private String password;
	@Column( name = "FULLNAME", nullable = false)
	private String fullname;
	@Column( name = "ISADMIN" , nullable = false)
	private Boolean isAdmin;
	
	public User(String username, String password, String fullname, Boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.isAdmin = isAdmin;
	}
	
	public User() {
		
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
