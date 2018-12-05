package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcUser;

public interface EcUserMapper {
    int deleteByPrimaryKey(Integer ecUid);

    int insert(EcUser record);

    int insertSelective(EcUser record);

    EcUser selectByPrimaryKey(Integer ecUid);

    int updateByPrimaryKeySelective(EcUser record);

    int updateByPrimaryKey(EcUser record);
}