package com.dbs.training.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dbs.training.model.Room;
import com.dbs.training.service.RoomService;
import com.dbs.training.validation.RoomValidator;

/**
 * Room Spring-MVC Controller.
 * 
 * @author John T Day
 */
@Controller
@RequestMapping(value = "/room")
public class RoomController extends AbstractCrudController<Room> {
	private static final Logger	logger	= Logger.getLogger(RoomController.class);

	@Autowired
	protected RoomService		entityService;

	@Autowired
	private RoomValidator		roomValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(roomValidator);
	}

	@Override
	protected ModelAndView getDropDowns(ModelAndView mav) {
		logger.debug("getDropDowns: mav=" + mav);
		return mav;
	}

	@Override
	protected Room buildNewEntity() {
		logger.debug("buildNewEntity: ");
		Room newEntity = new Room();
		newEntity.setFloor(1);
		newEntity.setNumberOfSeats(1);
		return newEntity;
	}

	@Override
	protected String getName() {
		return "room";
	}

	@Override
	protected RoomService getCrudService() {
		return entityService;
	}

}
