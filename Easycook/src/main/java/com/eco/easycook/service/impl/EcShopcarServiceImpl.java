package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcShopcarMapper;
import com.eco.easycook.service.EcShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcShopcarServiceImpl implements EcShopcarService {

    @Autowired
    private EcShopcarMapper ecShopcarMapper;

    @Override
    public Vo selectShopcarById(int uid) {

        Vo vo = new Vo();
        if (ecShopcarMapper.selectShopcarById(uid) != null) {
            vo.setCode(1000);
            vo.setData(ecShopcarMapper.selectShopcarById(uid));
        } else {
            vo.setCode(2000);
        }

        return vo;
    }

    @Override
    public Boolean deleteGoodsBySid(int sid) {

        return ecShopcarMapper.deleteByPrimaryKey(sid)>0?true:false;
    }
}
