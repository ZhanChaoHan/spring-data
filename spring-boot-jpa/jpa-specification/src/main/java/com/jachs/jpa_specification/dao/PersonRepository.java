package com.jachs.jpa_specification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jachs.jpa_specification.entity.oto.Person;


/***
 * 
 * @author zhanchaohan
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>,JpaSpecificationExecutor<Person>{

}
