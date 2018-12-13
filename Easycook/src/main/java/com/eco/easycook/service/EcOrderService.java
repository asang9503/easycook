package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.pojo.EcOrder;
import com.eco.easycook.util.ResultBean;

public interface EcOrderService {

    ResultBean selectOrderById(int gid);

    ResultBean addOrder(EcOrder ecOrder);

    ResultBean delOrder(int oid);

    ResultBean updateState(int ecOid);
}
