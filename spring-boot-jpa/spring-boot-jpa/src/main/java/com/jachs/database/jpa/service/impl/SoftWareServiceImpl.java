package com.jachs.database.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jachs.database.jpa.dao.otn.ComputerRepository;
import com.jachs.database.jpa.service.SoftWareService;

/***
 * 
 * @author zhanchaohan
 *
 */
@Service
public class SoftWareServiceImpl implements SoftWareService {
	@Autowired
	private ComputerRepository computerRepository;
	
}
