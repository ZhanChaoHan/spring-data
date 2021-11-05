package com.jachs.database.jpa.dao.ntm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jachs.database.jpa.entity.ntm.Exam;

//import com.jachs.database.config.multiple.TargetDataSource;
//import com.jachs.database.config.multiple.DataSourceType;

/**
 * @author zhanchaohan
 * 
 */
//@TargetDataSource(dataSource = DataSourceType.SLAVE)  //使用指定数据源
public interface ExamRepository extends JpaRepository<Exam,Integer>{

}
