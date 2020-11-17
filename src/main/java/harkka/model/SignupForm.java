package harkka.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupForm {
	@NotEmpty
	@Size(min = 5, max = 30)
	private String username = "";

	@NotEmpty
	@Size(min = 7, max = 30)
	private String password = "";

	@NotEmpty
	@Size(min = 7, max = 30)
	private String passwordCheck = "";

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String role = "USER";

	public String getEmail() {
		return password;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public String setEmail() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}