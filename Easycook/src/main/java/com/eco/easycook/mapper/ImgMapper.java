package com.eco.easycook.mapper;

import com.eco.easycook.pojo.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer ecGimgid);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer ecGimgid);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}