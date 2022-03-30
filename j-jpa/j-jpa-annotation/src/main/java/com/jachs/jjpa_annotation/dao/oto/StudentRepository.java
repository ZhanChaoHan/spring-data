package com.jachs.jjpa_annotation.dao.oto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.oto.Student;

/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,String>{

}
