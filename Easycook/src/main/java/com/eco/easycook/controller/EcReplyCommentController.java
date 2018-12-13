package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcReplycomment;
import com.eco.easycook.service.EcReplycommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nvarchar
 */
@RestController
@Api(value = "操作故事评论的回复数据接口", tags = {"故事评论的评论操作接口"})
public class EcReplyCommentController {

    @Autowired
    private EcReplycommentService service;

    @ApiOperation(value = "查询回复故事对应的评论的评论",httpMethod = "GET",notes = "实现展示故事的评论的回复" )
    @GetMapping("getReplyComment")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyid", value = "当前用户点击的评论所属故事的id", required=true, paramType="query"),
            @ApiImplicitParam(name = "commentid", value = "当前用户点击的评论的id", required=true, paramType="query"),
            @ApiImplicitParam(name = "token", value = "用户登录时生成的token", required=true, paramType="query")
    })
    public ResponseVo<EcReplycomment> getReplyComment(@RequestParam(name = "storyid")Integer storyid, @RequestParam(name = "commentid")Integer commentid, @RequestParam(name = "token")String token) {

        return service.getReplyComment(storyid, commentid, token);

    }


    @ApiOperation(value = "保存回复故事对应的评论的评论",httpMethod = "POST",notes = "实现保存故事的评论的回复" )
    @PostMapping("saveReplyComment")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replyid", value = "当前用户的id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "commentid", value = "当前用户回复的评论的id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "replycontent", value = "当前用户回复内容", required = true, paramType = "query"),
            @ApiImplicitParam(name = "token", value = "用户登录时生成的token", required=true, paramType="query")

    })
    public ResponseVo<EcReplycomment> saveReplyComment(EcReplycomment replycomment,  @RequestParam(name = "token") String token) {

        return service.saveReplyComment(replycomment, token);

    }

}
