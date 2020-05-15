package com.example.demo.controllers.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controllers.Exception.InvalidHeaderException;

@Component
public class LoggerInterceptors implements HandlerInterceptor {
Logger logger= LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
		System.out.println("in pre handler");
		logger.info("before handler execution");

		if(StringUtils.isEmpty(request.getHeader("topic-auth-key"))|! request.getHeader("topic-auth-key").equals("12345")) {
			throw new InvalidHeaderException("invalid request!");
		}
	
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception{
		System.out.println("in post handler");
		logger.info("hander execution is complete");

	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exeption) throws Exception{
		System.out.println("in after Completion");
		logger.info("Request is complete");

	}

	
}
