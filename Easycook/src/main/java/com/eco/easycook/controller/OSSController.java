package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.JedisUtil;
import com.eco.easycook.util.OSSUtil;
import com.eco.easycook.util.ResponseVoUtil;
import com.eco.easycook.util.token.SystemCon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/12/2 10:10
 */
@RestController
@Api(value = "操作故事附带的图片", tags = {"发布故事时图片上传接口(支持多上传)"})
public class OSSController {

    @Autowired
    private OSSUtil ossUtil;

    private JedisPool jedisPool = new JedisPool("120.79.198.64",6379);

    private JedisUtil jedisUtil = new JedisUtil(jedisPool,"root");
    //文件上传
    @PostMapping("storyImgUpload")
    public ResponseVo<List> upload(MultipartFile[] file, String token) throws IOException {

        if(jedisUtil.getHash(SystemCon.TOKENHASH,"token:" + token) != null && file.length != 0){
            List<String> path = new ArrayList<>();
            for (int i = 0; i < file.length; i++) {
                path.add(ossUtil.fileUp(file[i].getOriginalFilename(),file[i].getBytes()));
            }

            return new ResponseVo<>(1000, "success", path);
        }else{
            return ResponseVoUtil.setERROR("上传文件不能为空");
        }
    }
}
