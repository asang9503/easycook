package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcVote;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
public interface EcVoteService {

    /**
     *
     * @param vote 点赞对象
     * @return
     */
    ResponseVo<EcVote> saveVote(EcVote vote, String token);
}
