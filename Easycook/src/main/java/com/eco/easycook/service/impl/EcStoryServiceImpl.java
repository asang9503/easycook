package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcStoryMapper;
import com.eco.easycook.pojo.EcStory;
import com.eco.easycook.service.EcStoryService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcStoryServiceImpl implements EcStoryService {

    @Autowired
    private EcStoryMapper mapper;


    /**
     *根据用户id查询关注用户的故事
     * @param id 当前登录用户id
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithAttention(Integer id) {

        //判断前端传来的参数是否可用
        if (id == null || id == 0) {
            ResponseVo<EcStory> vo = ResponseVoUtil.setERROR("登陆后才能查看");

            return vo;
        } else {

            //查询出对应的故事
            List<EcStory> list = mapper.selectByUserId(id);

            //非装到返回方法中
            ResponseVo<EcStory> vo = new ResponseVo<>(2000, "success", list);

            return vo;
        }

    }

    /**
     *
     * 查询最热的故事（发现故事）
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithHot() {
        return null;
    }

    /**
     *
     * 查询最新的故事（最新故事）
     * @return
     */
    @Override
    public ResponseVo<EcStory> showStoryWithNew() {
        return null;
    }
}
