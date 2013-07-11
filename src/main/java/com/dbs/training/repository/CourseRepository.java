package com.dbs.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.training.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
