package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Questions;
import com.example.demo.model.Result;
import com.example.demo.service.ResultService;

@RestController
public class ResultController {
	@Autowired
	ResultService resultService;
	
	
	@PostMapping("course/{courseId}/questions/result")
	public Result getResult(@PathVariable("courseId") int cid, @RequestBody Questions questions){
		return resultService.findResult(cid, questions);
	}

}
