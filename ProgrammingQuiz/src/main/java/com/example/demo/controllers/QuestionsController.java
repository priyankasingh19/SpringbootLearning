package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Questions;
import com.example.demo.service.QuestionService;

@RestController
public class QuestionsController {

	@Autowired
	QuestionService questionService;

@PostMapping("/course/{courseId}/questions")
	public Questions save(@Valid @RequestBody Questions ques, @PathVariable("courseId") int cid) {
		System.out.println(ques.toString());
		return questionService.saveQuestion(ques, cid);
	}
	

	@GetMapping("/course/{courseId}/questions")
	public List<Questions> getAll( @PathVariable("courseId") int cid) {
		return questionService.getAllQuestions(cid);
	}
	
	@PutMapping("/course/{courseId}/questions/{quesId}")
	public Questions updateQues(@Valid @RequestBody Questions ques, @PathVariable("courseId") int cid, @PathVariable("quesId") int quesId) {
		return questionService.updateQuesById(ques, quesId, cid);
	}

	@DeleteMapping("/course/{courseId}/questions/{quesId}")
	public void DeleteQues( @PathVariable("courseId") int cid, @PathVariable("quesId") int quesId) {
	    questionService.deleteQuesById( quesId, cid);
	}
	
}
