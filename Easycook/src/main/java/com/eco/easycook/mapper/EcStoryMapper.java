package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcStory;

public interface EcStoryMapper {
    int deleteByPrimaryKey(Integer ecSid);

    int insert(EcStory record);

    int insertSelective(EcStory record);

    EcStory selectByPrimaryKey(Integer ecSid);

    int updateByPrimaryKeySelective(EcStory record);

    int updateByPrimaryKey(EcStory record);
}