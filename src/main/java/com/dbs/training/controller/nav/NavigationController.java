package com.dbs.training.controller.nav;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {
	private static final Logger	logger	= Logger.getLogger(NavigationController.class);

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		logger.debug("index: ");
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "wip" }, method = RequestMethod.GET)
	public ModelAndView wip() {
		logger.debug("wip: ");
		return new ModelAndView("wip");
	}

}
