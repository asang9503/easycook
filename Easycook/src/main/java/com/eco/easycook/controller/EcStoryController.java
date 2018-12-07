package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcStory;
import com.eco.easycook.service.EcStoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "操作故事数据接口", tags = {"故事操作接口"})
public class EcStoryController {

    @Autowired
    private EcStoryService service;

    @ApiOperation(value = "查询关注、最新、最热的故事",httpMethod = "GET",notes = "实现展示故事功能" )
    @RequestMapping("showStoryWithType")
    public ResponseVo<EcStory> showStoryWithAttention(@ApiParam(name = "id", value = "当前登录用户id") Integer id,
                                                      @ApiParam(name = "type", value = "当前访问的故事类型", required = true)String type) {
        return service.showStoryWithAttention(id, type);
    }

//    @ApiOperation(value = "查询点赞最多的故事",httpMethod = "GET",notes = "实现展示点赞最多故事功能" )
//    @RequestMapping("showHotStory")
//    public ResponseVo<EcStory> showHotStory() {
//        return service.showStoryWithHot();
//    }
//
//
//    @ApiOperation(value = "查询最新的故事",httpMethod = "GET",notes = "实现展示最新故事功能" )
//    @RequestMapping("showNewStory")
//    public ResponseVo<EcStory> showNewStory() {
//        return service.showStoryWithNew();
//    }
}
