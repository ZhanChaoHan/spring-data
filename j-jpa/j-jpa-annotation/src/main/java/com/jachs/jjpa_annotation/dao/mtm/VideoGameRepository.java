package com.jachs.jjpa_annotation.dao.mtm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.mto.VideoGame;
/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame,Long>{

}
