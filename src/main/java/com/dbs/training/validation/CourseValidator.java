package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Course;

@Component
public class CourseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Course course = (Course) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "generic.empty");

	}

}
