package com.eco.easycook.service.impl;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.mapper.EcStoryMapper;
import com.eco.easycook.pojo.EcStory;
import com.eco.easycook.service.EcStoryService;
import com.eco.easycook.util.ResponseVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResponseVo<EcStory> showStoryWithAttention(Integer id, String type) {


        //判断前端传来的参数是否可用
        if (type == null || type == "") {

            return ResponseVoUtil.setERROR("网络异常请重新刷新");
        } else {
            ResponseVo<EcStory> vo;
            switch (type) {

                 case "关注":
                     if (id == null || id == 0) {
                         vo = ResponseVoUtil.setERROR("登陆后才能查看");
                     } else {
                         vo = new ResponseVo<>(1000, "success", mapper.selectByUserId(id));

                     }
                 break;
                     //查询出最新发布的故事
                 case "最新": vo = new ResponseVo<>(1000, "success", mapper.selectWithPutTime());
                 break;
                 //查询出当前（最火）点赞对多的故事
                 case "最热": vo = new ResponseVo<>(1000, "success", mapper.selectWithVoteNum());
                 break;

                 default:
                     vo = ResponseVoUtil.setERROR("网络异常请重新刷新");

                     break;

            }
            //封装到返回方法中
            return vo;
        }

    }
//
//    /**
//     *
//     * 查询点赞最多的故事（发现故事）
//     * @return
//     */
//    @Override
//    public ResponseVo<EcStory> showStoryWithHot() {
//        return new ResponseVo<>1000, "success", mapper.selectWithVoteNum());
//    }
//
//    /**
//     *
//     * 查询最新的故事（最新故事）
//     * @return
//     */
//    @Override
//    public ResponseVo<EcStory> showStoryWithNew() {
//        return new ResponseVo<>(1000, "success", mapper.selectWithPutTime());
//    }
}
