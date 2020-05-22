package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Questions;

public interface QuestionService {
	
   public Questions saveQuestion(Questions ques,int  cid);
	
    public List<Questions> getAllQuestions(int cid) ;
    
    public Questions updateQuesById(Questions ques, int cid,int quesId);
	
    public void deleteQuesById(int id, int cid);
	
    //public Questions updateQuestionById(Questions ques, int id, int cid);
}
