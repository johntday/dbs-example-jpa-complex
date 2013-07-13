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
import com.dbs.training.model.Roster;
import com.dbs.training.service.RosterService;
import com.dbs.training.util.Utils;
import com.dbs.training.validation.RosterValidator;

@Controller
@RequestMapping(value = "/roster")
public class RosterController {
	private static final Logger	logger			= Logger.getLogger(RosterController.class);
	private static final String	MESSAGE_FORMAT	= "Roster successfully %s <br/> %s";

	@Autowired
	private RosterService		rosterService;

	@Autowired
	private RosterValidator		rosterValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(rosterValidator);
	}

	@RequestMapping(value = "/tostring/{id}", method = RequestMethod.GET)
	public ModelAndView toStringPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("object-toString");
		Roster roster = rosterService.findById(id);
		mav.addObject("object", roster.toString());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newRosterPage() {
		logger.debug("newRosterPage: ");
		ModelAndView mav = new ModelAndView("roster-new", "roster", new Roster());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewRoster(@ModelAttribute @Valid Roster roster, BindingResult result, final RedirectAttributes redirectAttributes) {
		logger.debug("createNewRoster: roster=" + roster);

		if (result.hasErrors())
			return new ModelAndView("roster-new");

		ModelAndView mav = new ModelAndView();
		String message = String.format(MESSAGE_FORMAT, "created", roster.toString());

		try {
			rosterService.create(roster);
		} catch (Throwable e) {
			logger.error("createNewRoster: roster=" + roster, e);
			message = Utils.unwindExceptionStackMessages(e);
		}
		mav.setViewName("redirect:/index");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView rosterListPage() {
		logger.debug("rosterListPage: ");
		ModelAndView mav = new ModelAndView("roster-list");
		List<Roster> rosterList = rosterService.findAll();
		mav.addObject("rosterList", rosterList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editRosterPage(@PathVariable Integer id) {
		logger.debug("editRosterPage: id=" + id);
		ModelAndView mav = new ModelAndView("roster-edit");
		Roster roster = rosterService.findById(id);
		mav.addObject("roster", roster);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editRoster(@ModelAttribute @Valid Roster roster, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("editRoster: roster=" + roster + ", id=" + id);

		if (result.hasErrors())
			return new ModelAndView("roster-edit");

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = String.format(MESSAGE_FORMAT, "updated", roster.toString());

		try {
			rosterService.update(roster);
		} catch (Throwable e) {
			logger.error("editRoster: roster=" + roster + ", id=" + id, e);
			message = Utils.unwindExceptionStackMessages(e);
		}

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteRoster(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("editRoster: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");

		Roster roster = rosterService.delete(id);
		String message = String.format(MESSAGE_FORMAT, "deleted", roster.toString());

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
