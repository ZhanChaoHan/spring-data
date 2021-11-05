package com.jachs.database.jpa.entity.oto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.jachs.database.jpa.entity.oto.Student;
import com.jachs.database.jpa.entity.oto.model.StudentModel;


/***
 * 
 * @author zhanchaohan
 *
 */
@Mapper
public interface StudentConverter {
	StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);
	
	@Mappings({
        @Mapping(source = "student.studentName", target = "studentName"),
        @Mapping(source = "studentCard.cardName", target = "cardName"),
        @Mapping(source = "studentCard.cardMonery", target="cardMonery")
    })
	StudentModel stuToModel(Student student);
	
	List<StudentModel> stuToListModel(List<Student> student);
}
