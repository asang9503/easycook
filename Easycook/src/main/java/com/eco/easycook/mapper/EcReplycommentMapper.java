package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcReplycomment;

import java.util.List;
import java.util.Map;

public interface EcReplycommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EcReplycomment record);

    int insertSelective(EcReplycomment record);

    EcReplycomment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EcReplycomment record);

    int updateByPrimaryKey(EcReplycomment record);

    List<EcReplycomment> selectByStoryidAndCommentId(Integer storyid, Integer commentid);
}