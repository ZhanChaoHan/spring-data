package dto.oto;

import lombok.Data;
import utill.Query;

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
