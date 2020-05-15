package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="course_name")
	@NotBlank
	private String courseName;
	
	@Column(name = "course_description")
	private String courseDescription;
	public Course() {
		
	}
	
	public Course(int id, String courseName, String courseDescription) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return courseDescription;
	}
	public void setDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription + "]";
	}


}
