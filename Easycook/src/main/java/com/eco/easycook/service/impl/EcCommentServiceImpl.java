package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcCommentMapper;
import com.eco.easycook.pojo.EcComment;
import com.eco.easycook.service.EcCommentService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nvarchar
 */
@Service
public class EcCommentServiceImpl implements EcCommentService {

    @Autowired
    private EcCommentMapper mapper;

    @Override
    public ResponseVo<EcComment> getCommentByStoryId(Integer storyid) {

        if (storyid == null || storyid == 0) {
            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        } else {

            return new ResponseVo<>(1000, "success", mapper.select(storyid));
        }


    }
}
