package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcCommentMapper;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.service.EcCommentService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Nvarchar
 */
@Service
public class EcCommentServiceImpl implements EcCommentService {

    @Autowired
    private EcCommentMapper mapper;

    private JedisUtil jedisUtil = new JedisUtil("120.79.198.64",6379,"root");

    /**
     *
     * @param storyid 故事ID
     * @return
     */
    @Override
    public ResponseVo<EcComment> getCommentByStoryId(Integer storyid) {

        //验证前段传来的参数
        if (storyid == null || storyid == 0) {
            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        } else {

            return new ResponseVo<>(1000, "success", mapper.select(storyid));
        }


    }

    /**
     *
     * @param comment 评论对象
     * @return
     */
    @Override
    public ResponseVo<EcComment> saveComment(EcComment comment, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.isKey(token) && comment != null) {

            return new ResponseVo<>(1000, "success", mapper.insertSelective(comment));
        } else {

            return ResponseVoUtil.setERROR("请登录");
        }

    }
}

