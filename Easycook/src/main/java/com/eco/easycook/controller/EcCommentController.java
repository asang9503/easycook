package com.eco.easycook.controller;

import com.eco.easycook.service.EcCommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "操作故事评论数据接口")
public class EcCommentController {

    @Autowired
    private EcCommentService service;
}
