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
import com.dbs.training.model.Clss;
import com.dbs.training.service.ClssService;
import com.dbs.training.service.CourseService;
import com.dbs.training.util.Utils;
import com.dbs.training.validation.ClssValidator;

/**
 * Clss Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/clss")
public class ClssController {
	private static final Logger	logger					= Logger.getLogger(ClssController.class);
	private static final String	MESSAGE_FORMAT_SUCCESS	= "Clss successfully %s <br/> %s";
	private static final String	MESSAGE_FORMAT_ERROR	= "Clss error with %s <br/> %s";

	@Autowired
	private ClssService			clssService;

	@Autowired
	private CourseService		courseService;

	@Autowired
	private ClssValidator		clssValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(clssValidator);
	}

	@RequestMapping(value = "/tostring/{id}", method = RequestMethod.GET)
	public ModelAndView toStringPage(@PathVariable Integer id) {
		logger.debug("toStringPage: id=" + id);
		ModelAndView mav = new ModelAndView("object-toString");
		Clss clss = clssService.findById(id);
		mav.addObject("object", clss.toString());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newClssPage() {
		logger.debug("newClssPage: ");
		Clss newClss = buildNewClss();
		ModelAndView mav = new ModelAndView("clss-new", "clss", newClss);
		getDropDowns(mav);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewClss(@ModelAttribute @Valid Clss clss, BindingResult result, final RedirectAttributes redirectAttributes) {
		logger.debug("createNewClss: clss=" + clss);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView("clss-new"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			Clss createdClss = clssService.create(clss);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "created", createdClss.toString());
		} catch (Throwable e) {
			logger.error("createNewClss: clss=" + clss, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "created", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView clssListPage() {
		logger.debug("clssListPage: ");
		ModelAndView mav = new ModelAndView("clss-list");
		List<Clss> clssList = clssService.findAll();
		mav.addObject("clssList", clssList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editClssPage(@PathVariable Integer id) {
		logger.debug("editClssPage: id=" + id);
		ModelAndView mav = getDropDowns(new ModelAndView("clss-edit"));
		Clss clss = clssService.findById(id);
		mav.addObject("clss", clss);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editClss(@ModelAttribute @Valid Clss clss, BindingResult result, @PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws ObjectNotFound {
		logger.debug("editClss: clss=" + clss + ", id=" + id);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView("clss-edit"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			Clss updatedClss = clssService.update(clss);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "updated", updatedClss.toString());
		} catch (ObjectNotFound e) {
			logger.error("editClss: Not clss found with id=" + id);
			message = String.format(MESSAGE_FORMAT_ERROR, "updated", "Clss not found with id=" + id);
		} catch (Throwable e) {
			logger.error("editClss: clss=" + clss + ", id=" + id, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "updated", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClss(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("deleteClss: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			Clss clssDeleted = clssService.delete(id);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "deleted", clssDeleted.toString());
		} catch (ObjectNotFound e) {
			logger.error("deleteClss: Not clss found with id=" + id);
			message = String.format(MESSAGE_FORMAT_ERROR, "delete", "Clss not found with id=" + id);
		} catch (Throwable e) {
			logger.error("deleteClss: id=" + id, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "delete", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	/**
	 * Get all data for drop-down lists on edit and create pages.
	 * 
	 * @param mav
	 *            input ModelAndView.
	 * @return output ModelAndView with drop-downs added.
	 */
	private ModelAndView getDropDowns(ModelAndView mav) {
		mav.addObject("courseList", courseService.getDropDownList());
		return mav;
	}

	/**
	 * Build clss for create-page with defaults.
	 * 
	 * @return clss for create-page.
	 */
	private Clss buildNewClss() {
		Clss newClss = new Clss();
		return newClss;
	}

}