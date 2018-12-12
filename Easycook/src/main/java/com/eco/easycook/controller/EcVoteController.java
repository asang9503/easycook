package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcVote;
import com.eco.easycook.service.EcVoteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:阿桑
 * Date:2018/12/8/008
 * Description: 内部使用严禁外泄
 */
@RestController
@Api(value = "操作故事点赞数据接口", tags = {"故事点赞操作接口"})
public class EcVoteController {

    @Autowired
    private EcVoteService service;

    @ApiOperation(value = "保存故事的点赞次数",httpMethod = "POST",notes = "实现保存故事的点赞次数" )
    @PostMapping("saveVote")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyid", value = "当前用户点击的故事的id", required=true,paramType="query"),
            @ApiImplicitParam(name = "ecUid", value = "当前点赞用户的id", required=true,paramType="query")
    })
    public ResponseVo<EcVote> saveComment(EcVote vote, @RequestParam(name = "token") String token) {

        return service.saveVote(vote, token);
    }
}
