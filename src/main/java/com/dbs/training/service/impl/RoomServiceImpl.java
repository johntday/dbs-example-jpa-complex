package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Room;
import com.dbs.training.repository.RoomRepository;
import com.dbs.training.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Resource
	private RoomRepository	roomRepository;

	@Override
	@Transactional
	public Room create(Room room) {
		Room createdRoom = room;
		return roomRepository.save(createdRoom);
	}

	@Override
	@Transactional
	public Room findById(int id) {
		return roomRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Room delete(int id) throws ObjectNotFound {
		Room deletedRoom = roomRepository.findOne(id);

		if (deletedRoom == null)
			throw new ObjectNotFound();

		roomRepository.delete(deletedRoom);
		return deletedRoom;
	}

	@Override
	@Transactional
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Room update(Room room) throws ObjectNotFound {
		Room updatedRoom = roomRepository.save(room);
		return updatedRoom;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		final String TEMPLATE = "%s (floor %d)";
		List<Room> roomList = roomRepository.findAll();

		Map<String, String> room = new LinkedHashMap<String, String>();
		for (Room c : roomList) {
			room.put(c.getId().toString(), String.format(TEMPLATE, c.getName(), c.getFloor()));
		}
		return room;
	}

}
