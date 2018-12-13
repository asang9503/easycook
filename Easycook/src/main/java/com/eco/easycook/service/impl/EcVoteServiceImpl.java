package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcVoteMapper;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.pojo.EcVote;
import com.eco.easycook.service.EcVoteService;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.token.SystemCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@Service
public class EcVoteServiceImpl implements EcVoteService {

    @Autowired
    private EcVoteMapper mapper;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);
    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");
    /**
     *
     * @param vote 点赞对象
     * @return
     */
    @Override
    public ResponseVo<EcVote> saveVote(EcVote vote, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && vote != null) {
            //查询是否点过赞
            EcVote vote1 = mapper.selectByTwoId(vote);
            //判断是否点赞
            if (vote1 == null) {

                int i = mapper.insertSelective(vote);

                if (i == 1) {

                    return ResponseVoUtil.setOk("success");
                } else {

                    return ResponseVoUtil.setERROR("点赞失败！");
                }

            } else {

                int i =  mapper.deleteByTwoId(vote);

                if (i == 1) {

                    return ResponseVoUtil.setOk("success");
                } else {

                    return ResponseVoUtil.setERROR("取消赞失败！");
                }

            }
        } else {

            return ResponseVoUtil.setERROR("网络异常请刷新");
        }

    }
}
