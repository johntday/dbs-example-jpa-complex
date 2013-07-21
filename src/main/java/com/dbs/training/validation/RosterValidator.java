package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Classcomment;
import com.dbs.training.model.Roster;

@Component
public class RosterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		if (Roster.class.isAssignableFrom(clazz))
			return true;
		return Classcomment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Roster) {
			Roster roster = (Roster) target;

			// REQUIRED fields
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "student.id", "generic.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "classinstance.id", "generic.empty");
		} else if (target instanceof Classcomment) {
			Classcomment classcomment = (Classcomment) target;

			// REQUIRED fields
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "generic.empty");

			if (classcomment.getScore() != null && (classcomment.getScore() < 1 || classcomment.getScore() > 10))
				errors.rejectValue("score", "classcomment.score.btw1and10", "classcomment.score must be an integer between/equal 1 and 10");
		}
	}

}
