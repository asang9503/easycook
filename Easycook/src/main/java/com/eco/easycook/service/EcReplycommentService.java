package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcReplycomment;

/**
 * @author Nvarchar
 */
public interface EcReplycommentService {
    /**
     *
     * @param storyid 当前故事的id
     * @param commentid 当前回复的评论的id
     * @return
     */
    ResponseVo<EcReplycomment> getReplyComment(Integer storyid, Integer commentid, String token);

    /**
     *
     * @param replycomment 回复评论对象
     * @return
     */
    ResponseVo<EcReplycomment> saveReplyComment(EcReplycomment replycomment, String token);


}
