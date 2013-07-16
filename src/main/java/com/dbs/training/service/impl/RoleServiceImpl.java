package com.dbs.training.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Role;
import com.dbs.training.repository.RoleRepository;
import com.dbs.training.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleRepository	roleRepository;

	@Override
	@Transactional
	public Role create(Role role) {
		Role createdRole = role;
		return roleRepository.save(createdRole);
	}

	@Override
	@Transactional
	public Role findById(int id) {
		return roleRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Role delete(int id) throws ObjectNotFound {
		Role deletedRole = roleRepository.findOne(id);

		if (deletedRole == null)
			throw new ObjectNotFound();

		roleRepository.delete(deletedRole);
		return deletedRole;
	}

	@Override
	@Transactional
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = ObjectNotFound.class)
	public Role update(Role role) throws ObjectNotFound {
		Role updatedRole = roleRepository.save(role);
		return updatedRole;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> getDropDownList() {
		List<Role> roleList = roleRepository.findAll();

		Map<String, String> role = new LinkedHashMap<String, String>();
		for (Role c : roleList) {
			role.put(c.getId().toString(), c.getName());
		}
		return role;
	}

}
