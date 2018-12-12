package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcOrder;

import java.util.List;

public interface EcOrderMapper {
    int deleteByPrimaryKey(Integer ecOid);

    int insert(EcOrder record);

    int insertSelective(EcOrder record);

    EcOrder selectByPrimaryKey(Integer ecOid);

    int updateByPrimaryKeySelective(EcOrder record);

    int updateByPrimaryKey(EcOrder record);

    List<EcOrder> selectOrderById(int gid);
}