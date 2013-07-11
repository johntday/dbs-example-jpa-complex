package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Clss;

@Component
public class ClssValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Clss.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Clss clss = (Clss) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "course.id", "generic.empty");

	}

}
