package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcGoodsMapper;
import com.eco.easycook.service.EcGoodsService;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcGoodsServiceImpl implements EcGoodsService {

    @Autowired
    private EcGoodsMapper ecGoodsMapper;

    @Override
    public ResultBean selectAllGoods() {

        if (ecGoodsMapper.selectAllGoods() != null) {

            return ResultUtil.setOK("查询成功",ecGoodsMapper.selectAllGoods());
        } else {
            return ResultUtil.setError(100001,"查询失败",null);
        }

    }

    @Override
    public ResultBean selectGoodsByType(int typeid) {

        if (ecGoodsMapper.selectGoodsByType(typeid) != null) {
            return ResultUtil.setOK("查询成功",ecGoodsMapper.selectGoodsByType(typeid));

        } else {
            return ResultUtil.setError(100001,"查询失败",null);
        }


    }

    @Override
    public ResultBean selectGoodsById(int gid) {

        if (ecGoodsMapper.selectGoodsById(gid) != null) {
            return ResultUtil.setOK("查询成功",ecGoodsMapper.selectGoodsById(gid));

        } else {
            return ResultUtil.setError(100001,"查询失败",null);
        }

    }
}
