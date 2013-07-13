package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Course;
import com.dbs.training.repository.CourseRepository;
import com.dbs.training.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepository	courseRepository;

	@Override
	@Transactional
	public Course create(Course course) {
		Course createdCourse = course;
		return courseRepository.save(createdCourse);
	}

	@Override
	@Transactional
	public Course findById(int id) {
		return courseRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Course delete(int id) throws ObjectNotFound {
		Course deletedCourse = courseRepository.findOne(id);

		if (deletedCourse == null)
			throw new ObjectNotFound();

		courseRepository.delete(deletedCourse);
		return deletedCourse;
	}

	@Override
	@Transactional
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Course update(Course course) throws ObjectNotFound {
		Course updatedCourse = courseRepository.save(course);
		return updatedCourse;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		List<Course> courseList = courseRepository.findAll();

		Map<String, String> course = new LinkedHashMap<String, String>();
		for (Course c : courseList) {
			course.put(c.getId().toString(), c.getName());
		}
		return course;
	}

}
