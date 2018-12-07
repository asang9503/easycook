package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.service.EcCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "操作故事评论数据接口", tags = {"故事操作接口"})
public class EcCommentController {

    @Autowired
    private EcCommentService service;


    @ApiOperation(value = "查询故事对应的评论",httpMethod = "GET",notes = "实现展示故事的评论" )
    @RequestMapping("getCommentByStoryId")
    public ResponseVo<EcComment> getCommentByStoryId(@ApiParam(name = "storyid", value = "当前查看的故事的id")Integer storyid) {


        return service.getCommentByStoryId(storyid);
    }
}
