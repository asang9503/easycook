package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.pojo.EcOrder;

public interface EcOrderService {

    Vo selectOrderById(int gid);

    Vo addOrder(EcOrder ecOrder);

    Vo delOrder(int oid);
}
