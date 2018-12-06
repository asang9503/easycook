package com.eco.easycook.service.impl;

import com.eco.easycook.mapper.EcCommentMapper;
import com.eco.easycook.service.EcCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcCommentServiceImpl implements EcCommentService {

    @Autowired
    private EcCommentMapper mapper;
}
