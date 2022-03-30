package com.jachs.jjpa_annotation.dao.otn;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.otn.Computer;

/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface ComputerRepository extends JpaRepository<Computer,String>,JpaSpecificationExecutor<Computer>{
    
}
