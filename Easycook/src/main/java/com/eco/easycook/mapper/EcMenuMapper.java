package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcMenu;

public interface EcMenuMapper {
    int deleteByPrimaryKey(Integer ecMid);

    int insert(EcMenu record);

    int insertSelective(EcMenu record);

    EcMenu selectByPrimaryKey(Integer ecMid);

    int updateByPrimaryKeySelective(EcMenu record);

    int updateByPrimaryKey(EcMenu record);
}