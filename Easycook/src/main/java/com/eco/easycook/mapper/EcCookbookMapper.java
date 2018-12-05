package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcCookbook;

public interface EcCookbookMapper {
    int deleteByPrimaryKey(Integer ecCid);

    int insert(EcCookbook record);

    int insertSelective(EcCookbook record);

    EcCookbook selectByPrimaryKey(Integer ecCid);

    int updateByPrimaryKeySelective(EcCookbook record);

    int updateByPrimaryKey(EcCookbook record);
}