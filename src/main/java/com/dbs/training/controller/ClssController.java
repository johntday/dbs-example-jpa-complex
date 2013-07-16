package com.dbs.training.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Clss;
import com.dbs.training.service.ClssService;
import com.dbs.training.service.CourseService;
import com.dbs.training.validation.ClssValidator;

/**
 * Clss Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/clss")
public class ClssController extends AbstractCrudController<Clss> {
	private static final Logger	logger	= Logger.getLogger(ClssController.class);

	@Autowired
	private ClssService			entityService;

	@Autowired
	private CourseService		courseService;

	@Autowired
	private ClssValidator		clssValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(clssValidator);
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		mav.addObject("courseList", courseService.getDropDownList());
		return mav;
	}

	@Override
	protected Clss buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Clss newEntity = new Clss();
		return newEntity;
	}

	@Override
	protected String getName() {
		return "clss";
	}

	@Override
	protected ClssService getCrudService() {
		return entityService;
	}

}