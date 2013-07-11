package com.dbs.training.service;

import java.util.List;
import java.util.Map;
import com.dbs.training.exception.ObjectNotFound;
import com.dbs.training.model.Clss;

public interface ClssService {

	public Clss create(Clss clss);

	public Clss delete(int id) throws ObjectNotFound;

	public List<Clss> findAll();

	public Clss update(Clss clss) throws ObjectNotFound;

	public Clss findById(int id);

	public Map<String, String> getDropDownList();

}
