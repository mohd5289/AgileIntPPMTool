<<<<<<< HEAD
package io.agileintelligence.ppmtool.payload;

import javax.validation.constraints.NotBlank;

public class JWTSuccessResponse {
    
	private boolean success;
  
    private String token;

	public JWTSuccessResponse(boolean success, String token) {
		super();
		this.success = success;
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JWTSuccessResponse [success=" + success + ", token=" + token + "]";
	}
    
}
||||||| empty tree
=======
package io.agileintelligence.ppmtool.payload;

import javax.validation.constraints.NotBlank;

public class JWTSuccessResponse {
    
	private boolean success;
  
    private String token;

	public JWTSuccessResponse(boolean success, String token) {
		
		this.success = success;
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JWTSuccessResponse [success=" + success + ", token=" + token + "]";
	}
    
}
>>>>>>> origin/master
