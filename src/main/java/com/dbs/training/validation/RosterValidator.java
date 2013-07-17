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
		return Roster.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Roster roster = (Roster) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "student.id", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "classinstance.id", "generic.empty");

		if (roster.getComments() != null && roster.getComments().size() != 0) {
			for (Classcomment comment : roster.getComments()) {
				if (comment.getComment() == null || comment.getComment().isEmpty())
					errors.rejectValue("classcomment", "classcomment.empty", "classcomment cannot be null or empty");
				if (comment.getScore() != null)
					errors.rejectValue("score", "classcomment.score.nbw1to10", "classcomment.score must be an integer between/equal to 1 and 10");
			}
		}
	}

}
