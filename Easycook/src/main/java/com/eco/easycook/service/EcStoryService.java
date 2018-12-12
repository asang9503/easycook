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
     *
     * @return
     */
     ResponseVo<EcStory> showStoryWithAttention(String pageNum, String pageSize, Integer id, String token);

    /**
     *
     * 查询最热的故事（发现故事）
     * @return
     */
     ResponseVo<EcStory> showStoryWithType(String pageNum, String pageSize, String type);

    /**
     *
     * 查询最新的故事（最新故事）
     * @return
     */
     ResponseVo<EcStory> showStoryWithNew();

    /**
     *
     * @param story 故事对象
     * @return
     */
     ResponseVo<EcStory> saveStory(EcStory story, String[] fileName, String token);
}
