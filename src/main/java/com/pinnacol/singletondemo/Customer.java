package com.pinnacol.singletondemo;

public class Customer {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Customer [message=" + message + "]";
	}
	
	

}
