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
@Api(value = "操作故事数据接口")
public class EcStoryController {

    @Autowired
    private EcStoryService service;

    @ApiOperation(value = "查询关注的故事",httpMethod = "GET",notes = "实现展示故事功能" )
    @RequestMapping("showStoryWithAttention")
    public ResponseVo<EcStory> showStoryWithAttention(@ApiParam(name = "id", value = "当前登录用户id", required = true) Integer id) {
        return service.showStoryWithAttention(id);
    }
}
