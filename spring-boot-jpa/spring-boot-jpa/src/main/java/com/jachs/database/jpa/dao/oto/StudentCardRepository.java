package com.jachs.database.jpa.dao.oto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jachs.database.jpa.entity.oto.StudentCard;

/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard,String>{
	StudentCard findBycardName(String XXX);

	StudentCard findByCardNameAndCardType(String string, String string2);

	List<StudentCard> findByCardType(String string);
	//自定义JPA查询
	@Query("select u from StudentCard u where u.cardType like ?1%")
	List<StudentCard> findByAndSort(String cardType, Sort sort);
	
	//匿名占位符
	@Query("select u from StudentCard u where u.cardName = :cardName or u.cardType = :cardType")
	List<StudentCard> findByCardNameOrCardType(
			@Param("cardName") String cardName,
            @Param("cardType") String cardType);
	//分页
	@Query("select u from StudentCard u where u.cardType = ?1")
	Page<StudentCard> findByCardType(String string, Pageable pageable);
	
	//原生SQL
	@Query(value = "select * from studentcard where cardType=?1 order by cardId desc" ,nativeQuery = true)
	List<StudentCard> findByCardTypeAndSort(String cardTy);

}
