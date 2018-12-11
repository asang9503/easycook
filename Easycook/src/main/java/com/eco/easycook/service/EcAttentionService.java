package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcAttention;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
public interface EcAttentionService {
    /**
     *
     * @param attention 关注对象
     * @return
     */
    ResponseVo<EcAttention> saveAttention(EcAttention attention, String token);
}
