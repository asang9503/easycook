package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcCommentMapper;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.service.EcCommentService;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.token.SystemCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.List;


/**
 * @author Nvarchar
 */
@Service
public class EcCommentServiceImpl implements EcCommentService {

    @Autowired
    private EcCommentMapper mapper;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);
    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");

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
            //查询评论
            List<EcComment> list =  mapper.select(storyid);

            //判断是否为空
            if (list != null) {
                //有评论
                return new ResponseVo<>(1000, "success", list);
            } else {

                //无评论
                return ResponseVoUtil.setERROR("暂无评论");
            }


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
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && comment != null) {

            int i =  mapper.insertSelective(comment);

            if (i == 1) {

                return ResponseVoUtil.setOk("success");
            } else {

                return ResponseVoUtil.setERROR("评论失败");
            }

        } else {

            return ResponseVoUtil.setERROR("请登录");
        }

    }
}

