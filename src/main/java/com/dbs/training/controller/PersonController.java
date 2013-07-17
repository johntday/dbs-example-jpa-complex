package com.dbs.training.controller;

import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Person;
import com.dbs.training.model.Role;
import com.dbs.training.service.PersonService;
import com.dbs.training.service.RoleService;
import com.dbs.training.validation.PersonValidator;

/**
 * Person Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController extends AbstractCrudController<Person> {
	private static final Logger	logger	= Logger.getLogger(PersonController.class);

	@Autowired
	protected PersonService		entityService;

	@Autowired
	private PersonValidator		dtoValidator;

	@Autowired
	private RoleService			roleService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		logger.debug("initBinder: binder=" + binder);
		binder.setValidator(dtoValidator);
		binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class, true) {
			@Override
			protected Object convertElement(Object element) {
				Integer id = null;
				Role role = new Role();

				if (element instanceof String) {
					id = Integer.parseInt((String) element);
				} else if (element instanceof Integer) {
					id = (Integer) element;
				}
				role.setId(id);
				return id != null ? role : null;
			}
		});
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		mav.addObject("roleList", roleService.findAll());
		return mav;
	}

	@Override
	protected Person buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Person newEntity = new Person();
		newEntity.setActiveIndicator(1);
		return newEntity;
	}

	@Override
	protected String getName() {
		return "person";
	}

	@Override
	protected PersonService getCrudService() {
		return entityService;
	}

	@Override
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEntityPage(@PathVariable Integer id) {
		logger.debug("editEntityPage: id=" + id);
		ModelAndView mav = getDropDowns(new ModelAndView(getName() + "-edit"));
		Person entity = getCrudService().findByIdFull(id);
		mav.addObject(getName(), entity);
		return mav;
	}

}
