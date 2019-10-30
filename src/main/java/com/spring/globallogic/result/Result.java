package com.spring.globallogic.result;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result {
	private String		message;
	@JsonIgnore
	private Boolean		status 		= true;
	@JsonIgnore
	private HttpStatus	statusCode 	= HttpStatus.OK;
	
	public  Result(String message, Boolean status, HttpStatus statusCode) {
		this.message		= message;	
		this.status			= status;
		this.statusCode		= statusCode;
	}
	
	public Result() {}
	
	public String getMessage() {		
		return message;
	}

	public void setMessage(String message) {		
		this.message = message;
	}
	
	
	public Boolean getStatus() {		
		return status;
	}

	public void setStatus(boolean status) {		
		this.status = status;
	}
	
	public HttpStatus getStatusCode() {		
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {		
		this.statusCode = statusCode;
	}
	
    
}
		
