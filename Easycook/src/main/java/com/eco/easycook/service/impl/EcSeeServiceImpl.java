package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcSeeMapper;
import com.eco.easycook.pojo.EcSee;
import com.eco.easycook.service.EcSeeService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */

@Service
public class EcSeeServiceImpl implements EcSeeService {

    @Autowired
    private EcSeeMapper mapper;

    /**
     *
     * @param see 观看对象
     * @return
     */
    @Override
    public ResponseVo<EcSee> saveSee(EcSee see) {

        //前段传来的参数
        if (see != null) {

            int i = mapper.insert(see);

            if (i == 1) {
                return ResponseVoUtil.setOk("success");
            } else {
                return ResponseVoUtil.setERROR("网络开小差了");
            }

        } else {
            return ResponseVoUtil.setERROR("网络开小差了");
        }
    }
}
