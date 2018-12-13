package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.pojo.EcOrder;
import com.eco.easycook.service.EcOrderService;
import com.eco.easycook.util.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "订单接口", tags = {"订单接口"})
public class EcOrderController {

    @Autowired
    private EcOrderService ecOrderService;


    @GetMapping("/selectOrderById")
    @ApiOperation(value = "根据用户id查询订单",httpMethod = "GET",notes = "根据用户id查询订单信息" )
    public ResultBean selectOrderById(int gid) {

        return ecOrderService.selectOrderById(gid);
    }

    @GetMapping("/addOrder")
    @ApiOperation(value = "添加订单",httpMethod = "GET",notes = "添加订单" )
    public ResultBean addOrder(EcOrder ecOrder) {

        return ecOrderService.addOrder(ecOrder);
    }

    @GetMapping("/delOrder")
    @ApiOperation(value = "根据订单id删除订单",httpMethod = "GET",notes = "根据订单id删除订单" )
    public ResultBean delOrder(int oid) {

        return ecOrderService.delOrder(oid);
    }
    @GetMapping("/updateState")
    @ApiOperation(value = "根据订单id修改订单状态",httpMethod = "GET",notes = "根据订单id修改订单状态" )
    public ResultBean updateState(int ecOid) {

        return ecOrderService.updateState(ecOid);
    }

}
