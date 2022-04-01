package com.jachs.jjpa_specification.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_specification.entity.User;

/***
 * 
 * @author zhanchaohan
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
	
	@Query(value = "select ju.userName as userName,"
			+ "juInfo.phoneNum as phoneNum ,juInfo.Address as address"
			+" from User ju "
			+" join UserInfo juInfo on juInfo.id=ju.userId"
			+" where ju.userId=?1")
	List<Map<String, Object>> findUserVOByUserId(int uId);
}
