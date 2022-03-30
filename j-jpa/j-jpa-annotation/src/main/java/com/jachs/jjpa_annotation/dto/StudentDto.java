package com.jachs.jjpa_annotation.dto;


import com.jachs.jjpa_annotation.utill.Query;

import lombok.Data;

@Data
public class StudentDto {
	/** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String studentName;
    
//    @Query(joinName = "studentCard", propName = "cardId",type = Query.Type.INNER_LIKE)
//    private Integer studentId;
}
