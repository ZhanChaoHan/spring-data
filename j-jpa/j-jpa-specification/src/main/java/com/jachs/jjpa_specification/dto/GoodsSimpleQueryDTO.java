package com.jachs.jjpa_specification.dto;

import com.jachs.jjpa_specification.utill.Query;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
public class GoodsSimpleQueryDTO {
	@Query(type = Query.Type.RIGHT_LIKE)
	private String gName;//左模糊查询
	
}
