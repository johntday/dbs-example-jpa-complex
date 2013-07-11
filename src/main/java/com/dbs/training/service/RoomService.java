package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Room;

public interface RoomService {

	public Room create(Room room);

	public Room delete(int id) throws ObjectNotFound;

	public List<Room> findAll();

	public Room update(Room room) throws ObjectNotFound;

	public Room findById(int id);

	public Map<String, String> getDropDownList();

}
