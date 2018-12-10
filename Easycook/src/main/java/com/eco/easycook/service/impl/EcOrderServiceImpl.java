package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.mapper.EcOrderMapper;
import com.eco.easycook.pojo.EcOrder;
import com.eco.easycook.service.EcOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcOrderServiceImpl implements EcOrderService {

    @Autowired
    private EcOrderMapper ecOrderMapper;

    @Override
    public Vo selectOrderById(int gid) {
        Vo vo = new Vo();
        if (ecOrderMapper.selectOrderById(gid) != null) {
            vo.setCode(1000);
            vo.setData(ecOrderMapper.selectOrderById(gid));
        } else {
            vo.setCode(2000);
        }
        return vo;
    }

    @Override
    public Vo addOrder(EcOrder ecOrder) {

        Vo vo = new Vo();
        if (ecOrderMapper.insert(ecOrder)>0) {
            vo.setCode(1000);
            vo.setMsg("添加成功");
        } else {
            vo.setCode(2000);
            vo.setMsg("添加失败");
        }
        return vo;
    }

    @Override
    public Vo delOrder(int oid) {

        Vo vo = new Vo();
        if (ecOrderMapper.deleteByPrimaryKey(oid)>0) {
            vo.setCode(1000);
            vo.setMsg("删除成功");
        } else {
            vo.setCode(2000);
            vo.setMsg("删除失败");
        }
        return vo;
    }
}
