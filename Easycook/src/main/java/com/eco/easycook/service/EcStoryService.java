package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcStory;

/**
 * @author Nvarchar
 */
public interface EcStoryService {

    /**
     *根据用户id或者type查询故事
     * @param id 当前登录用户id
     * @param type 当前用户点击的故事类型（关注，最热，最新）
     * @return
     */
     ResponseVo<EcStory> showStoryWithAttention(Integer id, String type);

//    /**
//     *
//     * 查询最热的故事（发现故事）
//     * @return
//     */
//     ResponseVo<EcStory> showStoryWithHot();
//
//    /**
//     *
//     * 查询最新的故事（最新故事）
//     * @return
//     */
//     ResponseVo<EcStory> showStoryWithNew();
}
