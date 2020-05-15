package com.example.demo.model;

public class ErrorModel {
	private String errorType, description;

	public ErrorModel(String errorType, String description) {
		super();
		this.errorType = errorType;
		this.description = description;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
