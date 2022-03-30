package com.jachs.jjpa_specification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_specification.entity.Goods;

/***
 * 
 * @author zhanchaohan
 *
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer>{

}
