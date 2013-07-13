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
import com.dbs.training.model.Course;
import com.dbs.training.service.CourseService;
import com.dbs.training.validation.CourseValidator;

@Controller
@RequestMapping(value = "/course")
public class CourseController {
	private static final Logger	logger			= Logger.getLogger(CourseController.class);
	private static final String	MESSAGE_FORMAT	= "Course successfully %s <br/> %s";

	@Autowired
	private CourseService		courseService;

	@Autowired
	private CourseValidator		courseValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(courseValidator);
	}

	@RequestMapping(value = "/tostring/{id}", method = RequestMethod.GET)
	public ModelAndView toStringPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("object-toString");
		Course course = courseService.findById(id);
		mav.addObject("object", course.toString());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		logger.debug("newCoursePage: ");
		ModelAndView mav = new ModelAndView("course-new", "course", new Course());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("course-new");

		ModelAndView mav = new ModelAndView();
		String message = String.format(MESSAGE_FORMAT, "created", course.toString());

		courseService.create(course);
		mav.setViewName("redirect:/index");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView courseListPage() {
		ModelAndView mav = new ModelAndView("course-list");
		List<Course> courseList = courseService.findAll();
		mav.addObject("courseList", courseList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("course-edit");
		Course course = courseService.findById(id);
		mav.addObject("course", course);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ObjectNotFound {

		if (result.hasErrors())
			return new ModelAndView("course-edit");

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = String.format(MESSAGE_FORMAT, "updated", course.toString());

		courseService.update(course);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index");

		Course course = courseService.delete(id);
		String message = String.format(MESSAGE_FORMAT, "deleted", course.toString());

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
