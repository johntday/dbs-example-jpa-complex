package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;

public interface CrudService<T> {

	public T create(T person);

	public T delete(int id) throws ObjectNotFound;

	public List<T> findAll();

	public T update(T person) throws ObjectNotFound;

	public T findById(int id);

	public Map<String, String> getDropDownList();

}
