package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
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

	}

}
