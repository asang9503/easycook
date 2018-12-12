package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcShopcarMapper;
import com.eco.easycook.service.EcShopcarService;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import com.eco.easycook.util.token.SystemCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcShopcarServiceImpl implements EcShopcarService {

    @Autowired
    private EcShopcarMapper ecShopcarMapper;

    @Override
    public ResultBean selectShopcarById(int uid) {
        if (ecShopcarMapper.selectShopcarById(uid) != null) {
            return ResultUtil.setOK("查询成功",ecShopcarMapper.selectShopcarById(uid));

        } else {
            return ResultUtil.setError(100001,"查询失败",null);
        }
    }

    @Override
    public ResultBean deleteGoodsBySid(int sid) {
        if (ecShopcarMapper.deleteByPrimaryKey(sid)>0) {
            return ResultUtil.setOK("删除成功",null);

        } else {
            return ResultUtil.setError(SystemCon.RERROR1,"删除失败",null);
        }
    }
}
