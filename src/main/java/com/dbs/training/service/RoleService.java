package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Role;

public interface RoleService {

	public Role create(Role role);

	public Role delete(int id) throws ObjectNotFound;

	public List<Role> findAll();

	public Role update(Role role) throws ObjectNotFound;

	public Role findById(int id);

	public Map<String, String> getDropDownList();
}
