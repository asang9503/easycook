package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "EcCollectMapper")
public interface EcCollectMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcCollect record);

    int insertSelective(EcCollect record);

    EcCollect selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcCollect record);

    int updateByPrimaryKey(EcCollect record);

    int delBycidAndUid(EcCollect record);

    int delBycid(Integer cid);
}