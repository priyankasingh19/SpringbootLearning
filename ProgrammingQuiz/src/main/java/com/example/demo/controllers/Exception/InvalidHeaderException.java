package com.example.demo.controllers.Exception;

public class InvalidHeaderException extends RuntimeException {
	private String msg;

	public InvalidHeaderException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
