package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.controllers.Exception.ResourceNotFoundException;
import com.example.demo.model.Questions;
import com.example.demo.model.Result;

@Service
public class ResultServiceImp implements ResultService {
	
	@Autowired
	Result result;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	QuestionRepository questionRepo;

	@Override
	public Result findResult(int cid, Questions questions) {
	 courseRepo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("No Course Present!"));
	 System.out.println("finding result for question id :"+questions.getQuesId()  +"     "+ questions);
	
	 return questionRepo.findById(questions.getQuesId()).map(question->{
		                               result.setQuestion(question.getQuestion());
		                               result.setAnswer(question.getAnswer());
		                               if(question.getAnswer().equals(questions.getAnswer()))
		                            	{ 
		                            	   result.setYourAnswer("Correct!");
		                            	   }
		                               else {
		                            	   result.setYourAnswer("Incorrect!");
		                               }
		                               return result;
		                        }).orElseThrow(()-> new ResourceNotFoundException("No question present!"));


	}

}
