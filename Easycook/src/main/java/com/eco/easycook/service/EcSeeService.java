package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcSee;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
public interface EcSeeService {

    /**
     *
     * @param see 观看对象
     * @return
     */
    ResponseVo<EcSee> saveSee(EcSee see);
}
