package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.controllers.Exception.ResourceNotFoundException;
import com.example.demo.model.Course;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseRepository courseRepo;

	@Override
	public Course saveCourse(Course course) {
		return (Course) courseRepo.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseRepo.findAll();
		return courses;
	}

	@Override
	public Course getCourseById(int id) {
		return courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record present!"));
	}

	@Override
	public Course updateCourseById(Course course, int id) {

		Course updatedCourse = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record present!"));
		updatedCourse.setCourseName(course.getCourseName());
		updatedCourse.setCourseDescription(course.getCourseDescription());
		return courseRepo.save(updatedCourse);
	}

	@Override
	public void deleteCourseById(int id) {
		if (courseRepo.findById(id).isPresent()) {
			courseRepo.deleteById(id);
		} else {
			 throw new ResourceNotFoundException("No record present!");
		}
	}

}
