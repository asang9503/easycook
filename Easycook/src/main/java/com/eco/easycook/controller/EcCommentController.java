package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.service.EcCommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "操作故事评论数据接口", tags = {"故事操作评论接口"})
public class EcCommentController {

    @Autowired
    private EcCommentService service;


    @ApiOperation(value = "查询故事对应的评论",httpMethod = "GET",notes = "实现展示故事的评论" )
    @GetMapping("getCommentByStoryId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyid", value = "当前用户点击的故事的id", required=true,paramType="query")
    })
    public ResponseVo<EcComment> getCommentByStoryId(@ApiParam(name = "storyid", value = "当前查看的故事的id")Integer storyid) {


        return service.getCommentByStoryId(storyid);
    }


    @ApiOperation(value = "保存故事评论",httpMethod = "POST",notes = "实现保存故事的评论" )
    @PostMapping("saveComment")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyid", value = "当前用户评论的故事的id", required = true, paramType="query"),
            @ApiImplicitParam(name = "ecVid", value = "当前评论人的id", required = true, paramType="query"),
            @ApiImplicitParam(name = "ecConnent", value = "当前用户评论的内容", required = true, paramType="query")
    })
    public ResponseVo<EcComment> saveComment(EcComment comment, @RequestParam(name = "token") String token) {


        return service.saveComment(comment, token);
    }


}
