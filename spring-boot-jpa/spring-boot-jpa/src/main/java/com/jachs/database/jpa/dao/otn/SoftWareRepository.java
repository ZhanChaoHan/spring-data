package com.jachs.database.jpa.dao.otn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jachs.database.jpa.entity.otn.SoftWare;

/**
 * @author zhanchaohan
 * 
 */
public interface SoftWareRepository extends JpaRepository<SoftWare,String>,JpaSpecificationExecutor<SoftWare>{
	
}
