package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Result {
	
	private String question;
	private String answer;
	private String yourAnswer;
	
	public Result() {
		
	}
	

	public String getYourAnswer() {
		return yourAnswer;
	}


	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}


	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
	

}
