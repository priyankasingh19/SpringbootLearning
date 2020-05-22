package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseService {
	
    public Course saveCourse(Course course);
	
    public List<Course> getAllCourses() ;
	
    public Course getCourseById(int id);
	
    public void deleteCourseById(int id);
	
    public Course updateCourseById(Course course, int id);
}
