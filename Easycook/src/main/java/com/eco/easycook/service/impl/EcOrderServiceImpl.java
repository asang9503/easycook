package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcOrderMapper;
import com.eco.easycook.pojo.EcOrder;
import com.eco.easycook.service.EcOrderService;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import com.eco.easycook.util.token.SystemCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcOrderServiceImpl implements EcOrderService {

    @Autowired
    private EcOrderMapper ecOrderMapper;

    @Override
    public ResultBean selectOrderById(int gid) {

        if (ecOrderMapper.selectOrderById(gid) != null) {
            return ResultUtil.setOK("查询成功",ecOrderMapper.selectOrderById(gid));

        } else {
            return ResultUtil.setError(SystemCon.RERROR1,"查询失败",null);
        }
    }

    @Override
    public ResultBean addOrder(EcOrder ecOrder) {


        if (ecOrderMapper.insert(ecOrder)>0) {
            return ResultUtil.setOK("添加成功",null);

        } else {
           return ResultUtil.setError(SystemCon.RERROR1,"添加失败",null);
        }

    }

    @Override
    public ResultBean delOrder(int oid) {

        if (ecOrderMapper.deleteByPrimaryKey(oid)>0) {
            return ResultUtil.setOK("删除成功",null);

        } else {
            return ResultUtil.setError(SystemCon.RERROR1,"删除失败",null);
        }
    }

    @Override
    public ResultBean updateState(int ecOid) {

        if (ecOrderMapper.updateState(ecOid)>0) {
            return ResultUtil.setOK("修改成功",null);

        } else {
            return ResultUtil.setError(SystemCon.RERROR1,"修改失败",null);
        }
    }
}
