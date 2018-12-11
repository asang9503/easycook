package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcSee;

import java.util.List;

public interface EcSeeMapper {
    int deleteByPrimaryKey(Integer ecSeesid);

    int insert(EcSee record);

    int insertSelective(EcSee record);

    EcSee selectByPrimaryKey(Integer ecSeesid);

    int updateByPrimaryKeySelective(EcSee record);

    int updateByPrimaryKey(EcSee record);

    List<EcSee> selectSeeCountById(Integer id);

    List<EcSee> selectSeeCount();
}