package com.dbs.training.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Roster;
import com.dbs.training.service.ClassinstanceService;
import com.dbs.training.service.RosterService;
import com.dbs.training.validation.RosterValidator;

/**
 * Roster Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/roster")
public class RosterController extends AbstractCrudController<Roster> {
	private static final Logger		logger	= Logger.getLogger(RosterController.class);

	@Autowired
	private RosterService			entityService;

	@Autowired
	private RosterService			personService;

	@Autowired
	private ClassinstanceService	classinstanceService;

	@Autowired
	private RosterValidator			rosterValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(rosterValidator);
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		mav.addObject("studentList", personService.getDropDownList());
		mav.addObject("classinstanceList", classinstanceService.getDropDownList());
		return mav;
	}

	@Override
	protected Roster buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Roster newEntity = new Roster();
		return newEntity;
	}

	@Override
	protected String getName() {
		return "roster";
	}

	@Override
	protected RosterService getCrudService() {
		return entityService;
	}

}
