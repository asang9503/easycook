package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcGoodsMapper;
import com.eco.easycook.service.EcGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcGoodsServiceImpl implements EcGoodsService {

    @Autowired
    private EcGoodsMapper ecGoodsMapper;

    @Override
    public Vo selectAllGoods() {

        Vo vo = new Vo();
        vo.setCode(1000);
        vo.setData(ecGoodsMapper.selectAllGoods());

        return vo;
    }

    @Override
    public Vo selectGoodsByType(int typeid) {
        Vo vo = new Vo();

        if (ecGoodsMapper.selectGoodsByType(typeid) != null) {
            vo.setCode(1000);
            vo.setData(ecGoodsMapper.selectGoodsByType(typeid));
        } else {
            vo.setCode(2000);
        }
        return vo;

    }

    @Override
    public Vo selectGoodsById(int gid) {

        Vo vo = new Vo();

        if (ecGoodsMapper.selectGoodsById(gid) != null) {
            vo.setCode(1000);
            vo.setData(ecGoodsMapper.selectGoodsById(gid));
        } else {
            vo.setCode(2000);
        }
        return vo;
    }
}
