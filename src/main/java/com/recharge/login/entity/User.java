package com.recharge.login.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "recharge_user", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "is_admin", nullable = false)
	private boolean isAdmin;

	public User() {
		super();

	}

	public User(long id, String name, String username, String password, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", isAdmin="
				+ isAdmin + "]";
	}

}
