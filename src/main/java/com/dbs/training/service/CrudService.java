package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;

public interface CrudService<T> {

	public T create(T entity);

	public T delete(int id) throws ObjectNotFound;

	public List<T> findAll();

	public T update(T entity) throws ObjectNotFound;

	public T findById(int id);

	public Map<String, String> getDropDownList();

}
