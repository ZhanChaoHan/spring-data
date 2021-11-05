package com.jachs.jpa_specification.dto.oto;

import com.jachs.jpa_specification.entity.oto.IdCard;
import com.jachs.jpa_specification.utill.Query;

import lombok.Data;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
public class PersonDto {
	@Query(type = Query.Type.EQUAL)
	private String NickName;
	@Query(type = Query.Type.INNER_LIKE)
	private String Email;

	@Query(joinName = "IdCard", propName="CId", join = Query.Join.RIGHT)
	private int Cid;
}
