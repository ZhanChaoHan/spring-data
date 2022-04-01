package com.jachs.jjpa_specification.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.jachs.jjpa_specification.base.BaseMapper;
import com.jachs.jjpa_specification.entity.UserInfo;
import com.jachs.jjpa_specification.entity.vo.UserInfoVO;

/***
 * 
 * @author zhanchaohan
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserInfoVO, UserInfo>{
}
