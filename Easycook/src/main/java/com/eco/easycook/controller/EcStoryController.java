package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcStory;
import com.eco.easycook.service.EcStoryService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "展示、发布故事数据接口", tags = {"展示、发布故事操作接口"})
public class EcStoryController {

    @Autowired
    private EcStoryService service;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "当前登录用户id", required=true,paramType="query"),
            @ApiImplicitParam(name = "token", value = "验证登录是否有效", required=true,paramType="query"),
            @ApiImplicitParam(name = "pageNum", value = "用户当前点击的页码", required=true,paramType="query"),
            @ApiImplicitParam(name = "pageSize", value = "每页故事数量（默认6）", required=true,paramType="query")
    })
    @ApiOperation(value = "查询当前用户关注的故事",httpMethod = "POST",notes = "实现展示故事功能" )
    @PostMapping("showWithIsAttintion")
    public ResponseVo<EcStory> showStoryWithAttention(@Param(value = "pageNum") Integer pageNum,
                                                      @Param(value = "pageSize")Integer pageSize,
                                                      @Param(value = "id")Integer id,
                                                      @Param(value = "token")String token) {

        return service.showStoryWithAttention(pageNum, pageSize, id, token);
    }

    @ApiOperation(value = "查询最新、最热(发现)的故事",httpMethod = "GET",notes = "实现展示故事功能" )
    @GetMapping("showWithType")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "当前用户点击的故事类型(最新/最热(发现))", required=true,paramType="query"),
            @ApiImplicitParam(name = "pageNum", value = "用户当前点击的页码", required=true,paramType="query"),
            @ApiImplicitParam(name = "pageSize", value = "每页故事数量（默认5）", required=true,paramType="query")
    })
    public ResponseVo<EcStory> showHotStory(@Param(value = "pageNum")Integer pageNum, @Param(value = "pageSize")Integer pageSize,@Param(value = "type")  String type) {

        System.out.println(pageNum);
        System.out.println(pageSize);

        return service.showStoryWithType(pageNum, pageSize, type);
    }


    @ApiOperation(value = "发布故事",httpMethod = "POST",notes = "实现发布故事功能" )
    @PostMapping("saveStory")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ecTitle", value = "故事标题", required=true,paramType="query"),
            @ApiImplicitParam(name = "ecScontent", value = "故事内容", required=true,paramType="query"),
            @ApiImplicitParam(name = "ecUid", value = "故事发表用户id、", required=true,paramType="query"),
            @ApiImplicitParam(name = "imgName", value = "故事发表附带的图片",paramType="query"),
            @ApiImplicitParam(name = "token", value = "验证登录有效", required=true,paramType="query"),
    })
    public ResponseVo<EcStory> saveStory(EcStory story, String[] imgName, @Param(value = "token") String token) {
        return service.saveStory(story, imgName, token);
    }



//    @ApiOperation(value = "查询最新的故事",httpMethod = "GET",notes = "实现展示最新故事功能" )
//    @RequestMapping("showNewStory")
//    public ResponseVo<EcStory> showNewStory(EcStory story) {
//        return mapper.insert(story) == 0 ? new ResponseVo<>(1000,"success",null) : new ResponseVo<>(1000,"success",null);
//    }
}
