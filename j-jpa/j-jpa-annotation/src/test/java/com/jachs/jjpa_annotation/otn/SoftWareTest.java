package com.jachs.jjpa_annotation.otn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.jjpa_annotation.dao.otn.SoftWareRepository;


/**
 * @author zhanchaohan
 */
@SpringBootTest
public class SoftWareTest {
    @Autowired
    private SoftWareRepository softWareRepository;
    
    
}
