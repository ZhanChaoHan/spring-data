package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import base.BaseMapper;
import entity.oto.Person;
import vo.oto.PersonVo;

/***
 * 
 * @author zhanchaohan
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper extends BaseMapper<PersonVo, Person>{
}
