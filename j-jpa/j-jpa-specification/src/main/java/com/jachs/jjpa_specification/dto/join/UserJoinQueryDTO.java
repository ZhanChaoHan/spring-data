package com.jachs.jjpa_specification.dto.join;

import com.jachs.jjpa_specification.utill.Query;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
public class UserJoinQueryDTO {
	@Query(type = Query.Type.EQUAL)
	private String Address;
	
}
