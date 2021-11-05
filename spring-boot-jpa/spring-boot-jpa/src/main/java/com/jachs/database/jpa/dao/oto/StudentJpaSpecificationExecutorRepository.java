package com.jachs.database.jpa.dao.oto;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jachs.database.jpa.entity.oto.Student;


/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface StudentJpaSpecificationExecutorRepository extends JpaRepository<Student, String>,JpaSpecificationExecutor<Student>{
	@Query("select s from Student s where s.studentName like %?1%")
	List<Student> findNameLike(String name);
	
}
