package com.dbs.training.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Classcomment;
import com.dbs.training.service.ClasscommentService;
import com.dbs.training.validation.ClasscommentValidator;

/**
 * Classcomment Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/classcomment")
public class ClasscommentController extends AbstractCrudController<Classcomment> {
	private static final Logger		logger	= Logger.getLogger(ClasscommentController.class);

	@Autowired
	protected ClasscommentService	entityService;

	@Autowired
	private ClasscommentValidator	classcommentValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(classcommentValidator);
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		return mav;
	}

	@Override
	protected Classcomment buildNewEntity() {
		Classcomment newEntity = new Classcomment();
		newEntity.setScore(5);
		return newEntity;
	}

	@Override
	protected String getName() {
		return "classcomment";
	}

	@Override
	protected ClasscommentService getCrudService() {
		return entityService;
	}

}
