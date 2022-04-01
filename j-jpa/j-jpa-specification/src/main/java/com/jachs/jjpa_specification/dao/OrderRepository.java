package com.jachs.jjpa_specification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_specification.entity.Order;

/***
 * 
 * @author zhanchaohan
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,String>,JpaSpecificationExecutor<Order>{

}
