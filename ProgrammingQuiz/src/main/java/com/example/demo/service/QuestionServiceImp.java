package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.controllers.Exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Questions;

@Service
public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	QuestionRepository quesRepo;
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Questions saveQuestion(Questions ques, int cid) {
		return courseRepo.findById(cid).map(course -> {
            ques.setCourse(course);
            return quesRepo.save(ques);
        }).orElseThrow(() -> new ResourceNotFoundException("No Course Present!"));
	}

	@Override
	public List<Questions> getAllQuestions(int cid) {
	courseRepo.findById(cid).orElseThrow(() -> new ResourceNotFoundException("No course Present!"));
     return quesRepo.findByCourseId(cid);	
	  
	}

	@Override
	public Questions updateQuesById(Questions ques, int cid, int quesId) {
    courseRepo.findById(cid).orElseThrow(() -> new ResourceNotFoundException("No course Present!")); 
   return quesRepo.findById(quesId).map(question ->{
    	 ques.setQuesId(quesId);
    	 ques.setCourse(question.getCourse());
    	 return quesRepo.save(ques);
    }).orElseThrow(() -> new ResourceNotFoundException("No Course Present!"));

	}

	@Override
	public void deleteQuesById(int id, int cid) {
	courseRepo.findById(cid).orElseThrow(() -> new ResourceNotFoundException("No course Present!")); 	
	quesRepo.deleteById(id);	
	}
	

}
