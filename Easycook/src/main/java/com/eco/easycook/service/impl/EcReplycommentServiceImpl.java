package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcReplycommentMapper;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.pojo.EcReplycomment;
import com.eco.easycook.service.EcReplycommentService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nvarchar
 */
@Service
public class EcReplycommentServiceImpl implements EcReplycommentService {

    @Autowired
    private EcReplycommentMapper mapper;

    private JedisUtil jedisUtil = new JedisUtil("120.79.198.64",6379,"root");

    /**
     *
     * @param storyid 当前故事的id
     * @param commentid 当前回复的评论的id
     * @return
     */
    @Override
    public ResponseVo<EcReplycomment> getReplyComment(Integer storyid, Integer commentid, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.isKey(token) && storyid != null && storyid != 0 && commentid != null && commentid != 0) {

            return new ResponseVo<>(1000, "success", mapper.selectByStoryidAndCommentId(storyid, commentid));
        } else {
            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        }

    }

    /**
     *
     * @param replycomment 回复评论对象
     * @return
     */
    @Override
    public ResponseVo<EcReplycomment> saveReplyComment(EcReplycomment replycomment, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.isKey(token) &&replycomment != null) {

            return new ResponseVo<>(1000, "success", mapper.insertSelective(replycomment));
        } else {
            return ResponseVoUtil.setERROR("请填写内容");
        }
    }
}
