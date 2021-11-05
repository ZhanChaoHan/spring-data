package com.jachs.database.jpa.entity.otn.dto;


import java.util.List;

import com.jachs.database.jpa.utill.Query;

import lombok.Data;

/***
 * 查询条件实体对象
 * @author zhanchaohan
 *
 */
@Data
public class ComputerDto {
	/** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String computerName;

    @Query(type = Query.Type.EQUAL)
    private Long computerPrice;

    @Query(type = Query.Type.BETWEEN)
    private List<String> madeTime;

    @Query(joinName = "softWares",propName = "cId")
    private String cId;
}
