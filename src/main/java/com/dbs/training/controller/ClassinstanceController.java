package com.dbs.training.controller;

import java.util.Date;
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
import com.dbs.training.model.Classinstance;
import com.dbs.training.service.ClassinstanceService;
import com.dbs.training.service.ClssService;
import com.dbs.training.service.PersonService;
import com.dbs.training.service.RoomService;
import com.dbs.training.validation.ClassinstanceValidator;

@Controller
@RequestMapping(value = "/classinstance")
public class ClassinstanceController {
	private static final Logger		logger			= Logger.getLogger(ClassinstanceController.class);
	private static final String		MESSAGE_FORMAT	= "Classinstance successfully %s <br/> %s";

	@Autowired
	private ClassinstanceService	classinstanceService;

	@Autowired
	private ClssService				clssService;

	@Autowired
	private RoomService				roomService;

	@Autowired
	private PersonService			personService;

	@Autowired
	private ClassinstanceValidator	classinstanceValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(classinstanceValidator);
	}

	@RequestMapping(value = "/tostring/{id}", method = RequestMethod.GET)
	public ModelAndView toStringPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("object-toString");
		Classinstance classinstance = classinstanceService.findById(id);
		mav.addObject("object", classinstance.toString());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newClassinstancePage() {
		logger.debug("newClassinstancePage: ");
		Classinstance newClassinstance = new Classinstance();
		newClassinstance.setDateTime(new Date()); // default to now
		newClassinstance.setDurationMinutes(30); // default 30 minutes
		ModelAndView mav = new ModelAndView("classinstance-new", "classinstance", newClassinstance);

		getDropDowns(mav);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewClassinstance(@ModelAttribute @Valid Classinstance classinstance, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		logger.debug("createNewClassinstance: classinstance=" + classinstance);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView("classinstance-new"));

		ModelAndView mav = new ModelAndView();
		String message = String.format(MESSAGE_FORMAT, "created", classinstance.toString());

		classinstanceService.create(classinstance);
		mav.setViewName("redirect:/index");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView classinstanceListPage() {
		logger.debug("classinstanceListPage: ");
		ModelAndView mav = new ModelAndView("classinstance-list");
		List<Classinstance> classinstanceList = classinstanceService.findAll();
		mav.addObject("classinstanceList", classinstanceList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editClassinstancePage(@PathVariable Integer id) {
		logger.debug("classinstanceListPage: id=" + id);
		ModelAndView mav = new ModelAndView("classinstance-edit");
		Classinstance classinstance = classinstanceService.findById(id);
		mav.addObject("classinstance", classinstance);

		getDropDowns(mav);

		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editClassinstance(@ModelAttribute @Valid Classinstance classinstance, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("classinstanceListPage: classinstance=" + classinstance + ", id=" + id);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView("classinstance-edit"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = String.format(MESSAGE_FORMAT, "updated", classinstance.toString());

		classinstanceService.update(classinstance);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClassinstance(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("classinstanceListPage: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");

		Classinstance classinstance = classinstanceService.delete(id);
		String message = String.format(MESSAGE_FORMAT, "deleted", classinstance.toString());

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	private ModelAndView getDropDowns(ModelAndView mav) {
		mav.addObject("clssList", clssService.getDropDownList());
		mav.addObject("roomList", roomService.getDropDownList());
		mav.addObject("instructorList", personService.getDropDownList());
		return mav;
	}
}
