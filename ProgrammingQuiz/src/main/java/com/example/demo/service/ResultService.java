package com.example.demo.service;

import com.example.demo.model.Questions;
import com.example.demo.model.Result;

public interface ResultService {
	
	public Result findResult(int cid, Questions questions);

}
