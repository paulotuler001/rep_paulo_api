package br.com.api.trabapi.entities;

public class LoginResponse {

	private String token;

	
	
	
	public LoginResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
