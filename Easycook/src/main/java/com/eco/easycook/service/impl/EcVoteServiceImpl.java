package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcVoteMapper;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.pojo.EcVote;
import com.eco.easycook.service.EcVoteService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@Service
public class EcVoteServiceImpl implements EcVoteService {

    @Autowired
    private EcVoteMapper mapper;

    private JedisUtil jedisUtil = new JedisUtil("120.79.198.64",6379,"root");

    /**
     *
     * @param vote 点赞对象
     * @return
     */
    @Override
    public ResponseVo<EcVote> saveVote(EcVote vote, String token) {

        //验证token和前段传来的参数
        if (jedisUtil.isKey(token) && vote != null) {

            EcVote vote1 = mapper.selectByTwoId(vote);

            if (vote1 == null) {
                return new ResponseVo<>(1000, "success", mapper.insertSelective(vote));
            } else {
                return new ResponseVo<>(1000, "success", mapper.deleteByTwoId(vote));
            }
        } else {
            return ResponseVoUtil.setERROR("网络异常请刷新");
        }

    }
}