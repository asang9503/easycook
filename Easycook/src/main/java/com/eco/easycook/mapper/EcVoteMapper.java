package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcVote;

public interface EcVoteMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcVote record);

    int insertSelective(EcVote record);

    EcVote selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcVote record);

    int updateByPrimaryKey(EcVote record);
}