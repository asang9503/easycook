package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcVote;

import java.util.List;

public interface EcVoteMapper {
    int deleteByTwoId(EcVote record);

    int insert(EcVote record);

    int insertSelective(EcVote record);

    EcVote selectByTwoId(EcVote record);

    int updateByPrimaryKeySelective(EcVote record);

    int updateByPrimaryKey(EcVote record);

    List<EcVote> selectVoteCountById(Integer id);

    List<EcVote> selectVoteCount();
}