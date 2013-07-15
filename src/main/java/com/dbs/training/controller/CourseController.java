package com.dbs.training.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Course;
import com.dbs.training.service.CourseService;
import com.dbs.training.validation.CourseValidator;

/**
 * Course Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController extends AbstractCrudController<Course> {
	private static final Logger	logger	= Logger.getLogger(CourseController.class);

	@Autowired
	protected CourseService		entityService;

	@Autowired
	private CourseValidator		courseValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(courseValidator);
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		return mav;
	}

	@Override
	protected Course buildNewEntity() {
		Course newEntity = new Course();
		return newEntity;
	}

	@Override
	protected String getName() {
		return "course";
	}

	@Override
	protected CourseService getCrudService() {
		return entityService;
	}

}
