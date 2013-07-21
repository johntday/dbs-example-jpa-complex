package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Classcomment;

@Component
public class ClasscommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Classcomment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Classcomment classcomment = (Classcomment) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "generic.empty");

		if (classcomment.getScore() != null && (classcomment.getScore() < 1 || classcomment.getScore() > 10))
			errors.rejectValue("score", "classcomment.score.btw1and10", "classcomment.score must be an integer between/equal 1 and 10");
	}

}
