package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.pojo.EcStory;

/**
 * @author Nvarchar
 */
public interface EcStoryService {

    /**
     *根据用户id查询关注用户的故事
     * @param id 当前登录用户id
     * @return
     */
     ResponseVo<EcStory> showStoryWithAttention(Integer id);

    /**
     *
     * 查询最热的故事（发现故事）
     * @return
     */
     ResponseVo<EcStory> showStoryWithHot();

    /**
     *
     * 查询最新的故事（最新故事）
     * @return
     */
     ResponseVo<EcStory> showStoryWithNew();
}
