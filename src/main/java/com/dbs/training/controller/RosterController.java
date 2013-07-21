package com.dbs.training.controller;

import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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
import com.dbs.training.model.Classcomment;
import com.dbs.training.model.Role;
import com.dbs.training.model.Roster;
import com.dbs.training.service.ClassinstanceService;
import com.dbs.training.service.PersonService;
import com.dbs.training.service.RosterService;
import com.dbs.training.util.Utils;
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
	private PersonService			personService;

	@Autowired
	private ClassinstanceService	classinstanceService;

	@Autowired
	private RosterValidator			rosterValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(rosterValidator);
	};

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		mav.addObject("studentList", personService.findByRoleCodeDropDown(Role.ROLE_STUDENT));
		mav.addObject("classinstanceList", classinstanceService.getDropDownList());
		mav.addObject("classcomment", new Classcomment());
		return mav;
	}

	@Override
	protected Roster buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Roster newEntity = new Roster();
		newEntity.setAttendanceIndicator(false);
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

	@Override
	protected Roster mergeEditEntity(Roster inputEntity, Roster fetchedEntity) {
		// update fetchedEntity with fields, ignore comments collection
		BeanUtils.copyProperties(inputEntity, fetchedEntity, new String[] { "comments" });
		return fetchedEntity;
	}

	@RequestMapping(value = "/addComment/{id}", method = RequestMethod.POST)
	public ModelAndView editEntityAddComment(@ModelAttribute @Valid Classcomment entity, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("editEntityAddComment: entity=" + entity + ", id=" + id);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView(getName() + "-edit"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			entity.setId(null);
			entityService.addComment(id, entity);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "created", entity.toString());
		} catch (ObjectNotFound e) {
			logger.error("editEntityAddComment: Not entity found with id=" + id);
			message = String.format(MESSAGE_FORMAT_ERROR, "created", "Entity not found with id=" + id);
		} catch (Throwable e) {
			logger.error("editEntityAddComment: entity=" + entity + ", id=" + id, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "created", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
