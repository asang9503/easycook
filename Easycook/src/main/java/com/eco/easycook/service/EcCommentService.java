package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcComment;

/**
 * @author Nvarchar
 */
public interface EcCommentService {

    ResponseVo<EcComment> getCommentByStoryId(Integer storyid);
}
