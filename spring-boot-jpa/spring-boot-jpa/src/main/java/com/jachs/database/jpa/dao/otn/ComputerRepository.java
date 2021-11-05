package com.jachs.database.jpa.dao.otn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jachs.database.jpa.entity.otn.Computer;

/**
 * @author zhanchaohan
 * 
 */
public interface ComputerRepository extends JpaRepository<Computer,String>,JpaSpecificationExecutor<Computer>{
    
}
