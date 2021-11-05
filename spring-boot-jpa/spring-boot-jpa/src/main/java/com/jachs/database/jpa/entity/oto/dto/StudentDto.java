package com.jachs.database.jpa.entity.oto.dto;



import com.jachs.database.jpa.utill.Query;

import lombok.Data;

@Data
public class StudentDto {
	/** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String studentName;
    
//    @Query(joinName = "studentCard", propName = "cardId",type = Query.Type.INNER_LIKE)
//    private Integer studentId;
}
