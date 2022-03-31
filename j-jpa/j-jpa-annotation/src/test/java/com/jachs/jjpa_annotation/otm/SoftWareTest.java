package com.jachs.jjpa_annotation.otm;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.otm.SoftWareRepository;
import com.jachs.jjpa_entity.otm.Computer;
import com.jachs.jjpa_entity.otm.SoftWare;


/**
 * @author zhanchaohan
 */
@SpringBootTest
public class SoftWareTest {
    @Autowired
    private SoftWareRepository softWareRepository;
    
}
