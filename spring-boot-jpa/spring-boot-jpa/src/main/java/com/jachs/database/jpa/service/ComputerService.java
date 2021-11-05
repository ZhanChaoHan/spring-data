package com.jachs.database.jpa.service;

import java.util.List;

import com.jachs.database.jpa.entity.otn.Computer;

public interface ComputerService {

	List<Computer> findAll();

	void deleteById(String id);

	void deleteById(String... id);

}
