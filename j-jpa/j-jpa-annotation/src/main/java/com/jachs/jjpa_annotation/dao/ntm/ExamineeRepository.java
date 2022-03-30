package com.jachs.jjpa_annotation.dao.ntm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.ntm.Examinee;




/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface ExamineeRepository extends JpaRepository<Examinee,Integer>{

}
