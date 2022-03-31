package com.jachs.jjpa_annotation.mto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.mtm.PlayerRepository;
import com.jachs.jjpa_annotation.dao.mtm.VideoGameRepository;
import com.jachs.jjpa_entity.mto.Player;
import com.jachs.jjpa_entity.mto.VideoGame;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class VideoGameTest {
    @Autowired
    private VideoGameRepository videoGameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    
    //单条添加
    @Test
    public void testAddOne () {
        Player p1 = new Player ();
        p1.setLevel ( 2 );
        p1.setPlayerUserName ( "新手玩家" );

        playerRepository.save ( p1 );
        
        VideoGame vg = new VideoGame ();
        vg.setGameName ( "LOL" );
        vg.setGamePrice ( 5412 );
        vg.setPlayer ( p1 );
        
        VideoGame vg1 = new VideoGame ();
        vg1.setGameName ( "OverWatch" );
        vg1.setGamePrice ( 5112 );
        vg1.setPlayer ( p1 );
        
        
        videoGameRepository.save ( vg );
        videoGameRepository.save ( vg1 );
    }
}
