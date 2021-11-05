package com.jachs.database.jpa.nto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.nto.PlayerRepository;
import com.jachs.database.jpa.entity.nto.Player;

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
