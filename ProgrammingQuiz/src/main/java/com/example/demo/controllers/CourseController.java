package com.example.demo.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

@RequestMapping("/course")
@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping("/save")
	public Course save(@Valid @RequestBody Course course) {
		System.out.println(course.toString());
		return courseService.saveCourse(course);
	}

	@GetMapping("/all")
	public List<Course> getAll() {
		return courseService.getAllCourses();
	}

	@GetMapping("/{courseId}")
	public Course getById(@PathVariable(name = "courseId") int id) {
		return courseService.getCourseById(id);

	}

	@PutMapping("/update/{courseId}")
	public Course updateById(@Valid @RequestBody Course course, @PathVariable("courseId") int id) {
		return courseService.updateCourseById(course, id);
	}

	@DeleteMapping("/delete/{courseId}")
	public void delete(@PathVariable(name = "courseId") int id) {
		courseService.deleteCourseById(id);
	}

}
