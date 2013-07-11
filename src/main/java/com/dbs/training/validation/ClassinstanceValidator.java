package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Classinstance;

@Component
public class ClassinstanceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Classinstance.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Classinstance classinstance = (Classinstance) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clss.id", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateTime", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructor.id", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "durationMinutes", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "room.id", "generic.empty");

		if (classinstance.getDurationMinutes() < 30)
			errors.rejectValue("durationMinutes", "classinstance.durationMinutes.gt30", "classinstance.durationMinutes must be at least 30 minutes");

	}

}
