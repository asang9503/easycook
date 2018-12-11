package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcComment;

/**
 * @author Nvarchar
 */
public interface EcCommentService {

    /**
     *
     * @param storyid
     * @return
     */
    ResponseVo<EcComment> getCommentByStoryId(Integer storyid);


    /**
     *
     * @param comment 评论对象
     * @return
     */
    ResponseVo<EcComment> saveComment(EcComment comment, String token);
}
