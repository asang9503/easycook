package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcStoryimg;

public interface EcStoryimgMapper {
    int deleteByPrimaryKey(Integer ecSimgid);

    int insert(EcStoryimg record);

    int insertSelective(EcStoryimg record);

    EcStoryimg selectByPrimaryKey(Integer ecSimgid);

    int updateByPrimaryKeySelective(EcStoryimg record);

    int updateByPrimaryKey(EcStoryimg record);
}