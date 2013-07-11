package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Course;

public interface CourseService {

	public Course create(Course course);

	public Course delete(int id) throws ObjectNotFound;

	public List<Course> findAll();

	public Course update(Course course) throws ObjectNotFound;

	public Course findById(int id);

	public Map<String, String> getDropDownList();

}
