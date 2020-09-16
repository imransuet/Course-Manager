package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.CourseDao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImplementation implements CourseService {

	
	@Autowired
	private CourseDao courseDao;

	public CourseServiceImplementation() {
		

		
	}

	@Override
	public List<Course> getCourses() {
	
		return courseDao.findAll();
	}

	@Override
	public Course addCourse(Course course) {

		courseDao.save(course);
		
		return course;
	}

	@Override
	public Course getCourse(long courseId) {
	
//		
	return courseDao.getOne(courseId);
	}

	@Override
	public Course updateCourse(Course course) {

//		list.forEach(e->{
//			if(e.getId()==course.getId())
//			{
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		
	
	// list= this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	Course enCourse=courseDao.getOne(parseLong);
	courseDao.delete(enCourse);	
	
	}

}
