package net.hoyoung.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity{

	@Column(nullable = false, length = 50)
	private String email;
	private String userId;
	private String password;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void update(User updateUser) {
		this.email = updateUser.getEmail();
		this.password = updateUser.getPassword();
		this.name = updateUser.getName();
	}

	public boolean isMatchPassword(String newPassword) {
		return this.password.matches(newPassword);
	}

	public boolean isMatchId(Long newId) {
		if(newId == null){
			return false;
		}
		return getId() == newId;
	}

}
