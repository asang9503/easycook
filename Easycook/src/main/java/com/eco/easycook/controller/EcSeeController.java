package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcSee;
import com.eco.easycook.service.EcSeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@RestController
@Api(value = "操作故事观看次数数据接口", tags = {"故事观看次数操作接口"})
public class EcSeeController {

    @Autowired
    private EcSeeService service;

    @ApiOperation(value = "保存故事观看次数",httpMethod = "POST",notes = "实现保存故事的观看次数" )
    @PostMapping("saveSee")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ecSeestoryid", value = "当前用户点击的故事的id", required=true,paramType="query"),
            @ApiImplicitParam(name = "ecUid", value = "当前点击的用户的id", required=true,paramType="query")
    })
    public ResponseVo<EcSee> saveComment(EcSee see) {

        return service.saveSee(see);
    }
}
