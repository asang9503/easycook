package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcAttention;
import com.eco.easycook.service.EcAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@RestController
@Api(value = "用户关注数据接口", tags = {"用户关注操作接口"})
public class EcAttentionController {

    @Autowired
    private EcAttentionService service;

    @ApiOperation(value = "保存用户关注",httpMethod = "GET",notes = "实现用户关注功能" )
    @GetMapping("saveAttention")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ecUid", value = "被关注人的id", required=true,paramType="query"),
            @ApiImplicitParam(name = "ecVid", value = "关注人的id", required=true,paramType="query")
    })
    public ResponseVo<EcAttention> saveComment(EcAttention attention, @RequestParam(name = "token") String token) {

        return service.saveAttention(attention, token);
    }
}
