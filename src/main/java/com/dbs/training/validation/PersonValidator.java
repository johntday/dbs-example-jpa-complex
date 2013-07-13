package com.dbs.training.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.dbs.training.model.Person;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;

		// REQUIRED fields
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activeIndicator", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "generic.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "generic.empty");

		if (person.getPhoneSms() != null && person.getPhoneSms().toString().length() != 10)
			errors.rejectValue("phoneSms", "person.phoneSms.lt10chars", "person.phoneSms must be 10 digits");

		if (person.getActiveIndicator() != 0 && person.getActiveIndicator() != 1)
			errors.rejectValue("activeIndicator", "person.activeIndicator.ne0or1", "person.activeIndicator must be 0 or 1");

		// if ((person != null) && (person.getRoles() == null ||
		// person.getRoles().size() == 0))
		// errors.rejectValue("roles", "person.roles.empty",
		// "person.roles must have at least one role");
	}
}
