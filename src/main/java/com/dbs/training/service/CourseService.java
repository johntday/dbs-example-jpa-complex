package com.dbs.training.service;

import java.util.Map;
import com.dbs.training.model.Course;

public interface CourseService extends CrudService<Course> {

	public Map<String, String> getDropDownList();

}
