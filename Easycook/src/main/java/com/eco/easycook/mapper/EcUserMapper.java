package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcUser;

public interface EcUserMapper {
    int deleteByPrimaryKey(Integer ecUid);

    Boolean insert(EcUser record) throws  Exception;

    int insertSelective(EcUser record);

    EcUser selectByPrimaryKey(Integer ecUid);

    int updateByPrimaryKeySelective(EcUser record);

    int updateByPrimaryKey(EcUser record);
    
    EcUser selectByName(String ecUsername);
}