package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcAttentionMapper;
import com.eco.easycook.pojo.EcAttention;
import com.eco.easycook.service.EcAttentionService;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@Service
public class EcAttentionServiceImpl implements EcAttentionService {

    @Autowired
    private EcAttentionMapper mapper;

    private JedisUtil jedisUtil = new JedisUtil("120.79.198.64",6379,"root");

    /**
     *
     * @param attention 关注对象
     * @return
     */
    @Override
    public ResponseVo<EcAttention> saveAttention(EcAttention attention, String token) {
        
        //验证token和前段传来的参数
        if (jedisUtil.isKey(token) && attention != null) {

            EcAttention attention1 = mapper.selectByTwoId(attention);
            //判断是否关注过是则取消关注否则关注
            if (attention1 == null) {
                return new ResponseVo<>(1000, "success", mapper.insertSelective(attention));
            } else {
                return new ResponseVo<>(1000, "success", mapper.deleteByTwoId(attention));
            }
        } else {
            return ResponseVoUtil.setERROR("网络异常请刷新");
        }


    }
}
