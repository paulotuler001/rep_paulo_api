package br.com.api.trabapi.dto;

public class MessageResponseDTO {

	private String message;
//	private String token;

//	public String getToken() {
//		return token;
//	}

//	public void setToken(String token) {
//		this.token = token;
//	}

	public MessageResponseDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
