package com.jachs.database.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jachs.database.jpa.dao.otn.ComputerRepository;
import com.jachs.database.jpa.entity.otn.Computer;
import com.jachs.database.jpa.service.ComputerService;

/***
 * 
 * @author zhanchaohan
 *
 */
@Service
public class ComputerServiceImpl implements ComputerService {
	@Autowired
	private ComputerRepository computerRepository;

	@Override
	public List<Computer> findAll() {
		return computerRepository.findAll();
	}

	@Override
	public void deleteById(String id) {
		computerRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteById(String... id) {
			for (String ids : id) {
//				Optional<Computer> computer = computerRepository.findById(ids);
				computerRepository.deleteById(ids);
			}
	}

}
