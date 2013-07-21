package com.dbs.training.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.service.CrudService;
import com.dbs.training.util.Utils;

/**
 * Entity CRUD Spring-MVC Controller.
 * 
 * @author John T Day
 */
public abstract class AbstractCrudController<T> {
	private static final Logger		logger					= Logger.getLogger(AbstractCrudController.class);
	protected static final String	MESSAGE_FORMAT_SUCCESS	= "Successfully %s <br/> %s";
	protected static final String	MESSAGE_FORMAT_ERROR	= "Error with %s <br/> %s";

	@RequestMapping(value = "/tostring/{id}", method = RequestMethod.GET)
	public ModelAndView toStringPage(@PathVariable Integer id) {
		logger.debug("toStringPage: id=" + id);
		ModelAndView mav = new ModelAndView("object-toString");
		T entity = getCrudService().findById(id);
		mav.addObject("object", entity.toString());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEntityPage() {
		logger.debug("newEntityPage: ");
		T newEntity = buildNewEntity();
		ModelAndView mav = new ModelAndView(getName() + "-new", getName(), newEntity);
		getDropDowns(mav);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEntity(@ModelAttribute @Valid T entity, BindingResult result, final RedirectAttributes redirectAttributes) {
		logger.debug("createNewEntity: entity=" + entity);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView(getName() + "-new"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			T createdEntity = getCrudService().create(entity);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "created", createdEntity.toString());
		} catch (Throwable e) {
			logger.error("createNewEntity: entity=" + entity, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "created", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView entityListPage() {
		logger.debug("entityListPage: ");
		ModelAndView mav = new ModelAndView(getName() + "-list");
		List<T> entityList = getCrudService().findAll();
		mav.addObject(getName() + "List", entityList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEntityPage(@PathVariable Integer id) {
		logger.debug("editEntityPage: id=" + id);
		ModelAndView mav = getDropDowns(new ModelAndView(getName() + "-edit"));
		T entity = getCrudService().findById(id);
		mav.addObject(getName(), entity);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEntity(@ModelAttribute @Valid T entity, BindingResult result, @PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws ObjectNotFound {
		logger.debug("editEntity: entity=" + entity + ", id=" + id);

		if (result.hasErrors())
			return getDropDowns(new ModelAndView(getName() + "-edit"));

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			T beforeUpdateEntity = getCrudService().findById(id);
			logger.debug("editEntity: beforeUpdateEntity=" + beforeUpdateEntity);
			T mergedEntity = mergeEditEntity(entity, beforeUpdateEntity);
			logger.debug("editEntity: mergedEntity=" + mergedEntity);
			T updatedEntity = getCrudService().update(mergedEntity);
			logger.debug("editEntity: updatedEntity=" + updatedEntity);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "updated", updatedEntity.toString());
		} catch (ObjectNotFound e) {
			logger.error("editEntity: Not entity found with id=" + id);
			message = String.format(MESSAGE_FORMAT_ERROR, "updated", "Entity not found with id=" + id);
		} catch (Throwable e) {
			logger.error("editEntity: entity=" + entity + ", id=" + id, e);
			message = String.format(MESSAGE_FORMAT_ERROR, "updated", Utils.unwindExceptionStackMessages(e));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEntity(@PathVariable Integer id, final RedirectAttributes redirectAttributes) throws ObjectNotFound {
		logger.debug("deleteEntity: id=" + id);

		ModelAndView mav = new ModelAndView("redirect:/index");
		String message = null;

		try {
			T entityDeleted = getCrudService().delete(id);
			message = String.format(MESSAGE_FORMAT_SUCCESS, "deleted", entityDeleted.toString());
		} catch (ObjectNotFound e) {
			logger.error("deleteEntity: Not entity found with id=" + id);
			message = String.format(MESSAGE_FORMAT_ERROR, "delete", "Entity not found with id=" + id);
		} catch (Throwable e) {
			logger.error("deleteEntity: id=" + id, e);
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
	protected abstract ModelAndView getDropDowns(ModelAndView mav);

	/**
	 * Build entity for create-page with defaults.
	 * 
	 * @return entity for create-page.
	 */
	protected abstract T buildNewEntity();

	/**
	 * Get view naming convention.
	 * 
	 * @return naming convention for view.
	 */
	protected abstract String getName();

	protected abstract CrudService<T> getCrudService();

	/**
	 * Do any merging between (1) input entity and (2) fetched database entity
	 * before sending to service for update. Default is to return
	 * <code>inputEntity</code>.
	 * 
	 * @param inputEntity
	 *            input entity.
	 * @param fetchedEntity
	 *            value fetched from database.
	 * @return merged entity.
	 */
	protected T mergeEditEntity(T inputEntity, T fetchedEntity) {
		return inputEntity;
	}

}
