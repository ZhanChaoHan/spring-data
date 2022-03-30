package com.jachs.jjpa_annotation.dao.nto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.jjpa_entity.nto.VideoGame;
/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame,Long>{

}
