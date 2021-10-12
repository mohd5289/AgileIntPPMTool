package io.agileintelligence.ppmtool.exceptions;

public class UsernameAlreadyExistResponse {
	String username;

	public UsernameAlreadyExistResponse(String username) {
		//super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
