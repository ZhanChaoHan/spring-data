package com.jachs.jpa_specification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jachs.jpa_specification.entity.oto.IdCard;


/***
 * 
 * @author zhanchaohan
 *
 */
@Repository
public interface IdCardRepository extends JpaRepository<IdCard,Integer>,JpaSpecificationExecutor<IdCard>{

}
