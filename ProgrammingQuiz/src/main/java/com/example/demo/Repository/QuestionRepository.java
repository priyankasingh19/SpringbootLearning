package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>{
 
public List<Questions> findByCourseId(int cid);



}
