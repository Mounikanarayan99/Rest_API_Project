package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> list;
	
	public CourseServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Course(143,"Java Core Course" ,"This Course contains basics of java"));
		list.add(new Course(4343, "Spring boot course" ,"creating rest api using spring boot"));
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				return c;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}

	@Override
	public String deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		for(Course c:list)
		{
			if(c.getId()==courseId)
			{
				list.remove(c);
				return "{message:Successfully deleted}";
			}
		}
		return "{error:Id not found}";
	}
	

}
