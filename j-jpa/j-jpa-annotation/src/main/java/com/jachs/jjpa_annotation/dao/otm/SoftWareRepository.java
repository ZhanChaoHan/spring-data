package com.jachs.jjpa_annotation.dao.otm;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.otm.SoftWare;

/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface SoftWareRepository extends JpaRepository<SoftWare,String>,JpaSpecificationExecutor<SoftWare>{
	
}
