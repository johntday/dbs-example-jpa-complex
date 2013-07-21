package com.dbs.training.controller;

import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Classinstance;
import com.dbs.training.model.Role;
import com.dbs.training.service.ClassinstanceService;
import com.dbs.training.service.ClssService;
import com.dbs.training.service.PersonService;
import com.dbs.training.service.RoomService;
import com.dbs.training.validation.ClassinstanceValidator;

/**
 * Classinstance Spring-MVC Controller.
 * 
 * @author John T Day
 */

@Controller
@RequestMapping(value = "/classinstance")
public class ClassinstanceController extends AbstractCrudController<Classinstance> {
	private static final Logger		logger	= Logger.getLogger(ClassinstanceController.class);

	@Autowired
	private ClassinstanceService	entityService;

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

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		mav.addObject("clssList", clssService.getDropDownList());
		mav.addObject("roomList", roomService.getDropDownList());
		mav.addObject("instructorList", personService.findByRoleCodeDropDown(Role.ROLE_INSTRUCTOR));
		return mav;
	}

	@Override
	protected Classinstance buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Classinstance newEntity = new Classinstance();
		newEntity.setDateTime(new Date());
		newEntity.setDurationMinutes(30);
		return newEntity;
	}

	@Override
	protected String getName() {
		return "classinstance";
	}

	@Override
	protected ClassinstanceService getCrudService() {
		return entityService;
	}

}
