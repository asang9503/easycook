package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcComment;

public interface EcCommentMapper {
    int deleteByPrimaryKey(Integer ecCid);

    int insert(EcComment record);

    int insertSelective(EcComment record);

    EcComment selectByPrimaryKey(Integer ecCid);

    int updateByPrimaryKeySelective(EcComment record);

    int updateByPrimaryKey(EcComment record);
}