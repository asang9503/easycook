package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcAttentionMapper;
import com.eco.easycook.pojo.EcAttention;
import com.eco.easycook.service.EcAttentionService;
import com.eco.easycook.mapper.JedisUtil;
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
public class EcAttentionServiceImpl implements EcAttentionService {

    @Autowired
    private EcAttentionMapper mapper;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);

    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");
    /**
     *
     * @param attention 关注对象
     * @return
     */
    @Override
    public ResponseVo<EcAttention> saveAttention(EcAttention attention, String token) {
        //验证token和前段传来的参数
        if (jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && attention != null) {

            //查询是否关注过该用户
            EcAttention attention1 = mapper.selectByTwoId(attention);
            //判断是否关注过是则取消关注否则关注
            if (attention1 == null) {

                int i = mapper.insertSelective(attention);

                if (i == 1) {

                    return ResponseVoUtil.setOk("success");
                } else {

                    return ResponseVoUtil.setERROR("关注失败");
                }


            } else {

                int i = mapper.deleteByTwoId(attention);

                if (i == 1) {

                    return ResponseVoUtil.setOk("success");
                } else {

                    return ResponseVoUtil.setERROR("取消关注失败");
                }

            }
        } else {
            return ResponseVoUtil.setERROR("网络异常请刷新");
        }


    }
}
