package com.jachs.jjpa_annotation.nto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.nto.PlayerRepository;
import com.jachs.jjpa_entity.nto.Player;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class PlayerTest {
    @Autowired
    private PlayerRepository playerRepository;
    
    @Test
    public void testAddOne() {
        Player plaryer=new Player();
        
        plaryer.setLevel ( 1 );
        plaryer.setPlayerUserName ( "菜鸟玩家" );
        
        playerRepository.save ( plaryer );
    }
}
