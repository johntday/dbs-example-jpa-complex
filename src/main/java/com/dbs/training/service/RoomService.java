package com.dbs.training.service;

import java.util.Map;
import com.dbs.training.model.Room;

public interface RoomService extends CrudService<Room> {

	public Map<String, String> getDropDownList();

}