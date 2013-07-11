package com.dbs.training.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Person;
import com.dbs.training.service.PersonService;
import com.dbs.training.util.Utils;
import com.dbs.training.validation.PersonValidator;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
	private static final Logger	logger			= Logger.getLogger(PersonController.class);
	private static final String	MESSAGE_FORMAT	= "Person successfully %s <br/> %s";

	@Autowired
	private PersonService		personService;

	@Autowired
	private PersonValidator		personValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newPersonPage() {
		logger.debug("newPersonPage: ");
		ModelAndView mav = new ModelAndView("person-new", "person", new Person());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewPerson(@ModelAttribute @Valid Person person, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		logger.debug("createNewPerson: person=" + person);

		if (result.hasErrors())
			return new ModelAndView("person-new");

		ModelAndView mav = new ModelAndView();
		String message = String.format(MESSAGE_FORMAT, "created", person.toString());

		try {
			personService.create(person);
		} catch (Throwable e) {
			logger.error("createNewPerson: person=" + person, e);
			message = Utils.unwindExceptionStackMessages(e);
		}
		mav.setViewName("redirect:/index");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView personListPage() {
		logger.debug("personListPage: ");
		ModelAndView mav = new ModelAndView("person-list");
		List<Person> personList = personService.findAll();
		mav.addObject("personList", personList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPersonPage(@PathVariable Integer id) {
		logger.debug("editPersonPage: id=" + id);
		ModelAndView mav = new ModelAndView("person-edit");
		Person person = personService.findById(id);
		mav.addObject("person", person);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editPerson(@ModelAttribute @Valid Person person, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("editPerson: person=" + person + ", id=" + id);

		if (result.hasErrors())
			return new ModelAndView("person-edit");

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = String.format(MESSAGE_FORMAT, "updated", person.toString());

		try {
			personService.update(person);
		} catch (Throwable e) {
			logger.error("editPerson: person=" + person + ", id=" + id, e);
			message = Utils.unwindExceptionStackMessages(e);
		}

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deletePerson(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("editPerson: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");

		Person person = personService.delete(id);
		String message = String.format(MESSAGE_FORMAT, "deleted", person.toString());

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
