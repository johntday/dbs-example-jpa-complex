package com.dbs.training.controller;

import java.beans.PropertyEditorSupport;
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
import com.dbs.training.model.Course;
import com.dbs.training.service.ClssService;
import com.dbs.training.service.CourseService;
import com.dbs.training.validation.ClssValidator;

@Controller
@RequestMapping(value = "/clss")
public class ClssController {
	private static final Logger	logger			= Logger.getLogger(ClssController.class);
	private static final String	MESSAGE_FORMAT	= "Clss successfully %s <br/> %s";

	@Autowired
	private ClssService			clssService;

	@Autowired
	private CourseService		courseService;

	@Autowired
	private ClssValidator		clssValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(clssValidator);
		binder.registerCustomEditor(Course.class, "course", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				logger.debug("initBinder.PropertyEditorSupport.setAsText: text=" + text);
				Course type = courseService.findById(Integer.parseInt(text));
				setValue(type);
			}
		});
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newClssPage() {
		logger.debug("newClssPage: ");
		ModelAndView mav = new ModelAndView("clss-new", "clss", new Clss());

		mav.addObject("courseList", courseService.getDropDownList());

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewClss(@ModelAttribute @Valid Clss clss, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		logger.debug("createNewClss: clss=" + clss);

		if (result.hasErrors())
			return new ModelAndView("clss-new");

		ModelAndView mav = new ModelAndView();
		String message = String.format(MESSAGE_FORMAT, "created", clss.toString());

		clssService.create(clss);
		mav.setViewName("redirect:/index");

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
		logger.debug("clssListPage: id=" + id);
		ModelAndView mav = new ModelAndView("clss-edit");
		Clss clss = clssService.findById(id);
		mav.addObject("clss", clss);
		mav.addObject("courseList", courseService.getDropDownList());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editClss(@ModelAttribute @Valid Clss clss, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("clssListPage: clss=" + clss + ", id=" + id);

		if (result.hasErrors())
			return new ModelAndView("clss-edit");

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = String.format(MESSAGE_FORMAT, "updated", clss.toString());

		clssService.update(clss);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClss(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("clssListPage: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");

		Clss clss = clssService.delete(id);
		String message = String.format(MESSAGE_FORMAT, "deleted", clss.toString());

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
