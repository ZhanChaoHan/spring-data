package com.jachs.jpa_specification.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.jachs.jpa_specification.base.BaseMapper;
import com.jachs.jpa_specification.entity.oto.Person;
import com.jachs.jpa_specification.vo.oto.PersonVo;

/***
 * 
 * @author zhanchaohan
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper extends BaseMapper<PersonVo, Person>{
}
