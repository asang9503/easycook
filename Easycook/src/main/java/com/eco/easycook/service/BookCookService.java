package com.eco.easycook.service;

import com.eco.easycook.pojo.EcCookbook;
import com.eco.easycook.util.ResultBean;

public interface BookCookService {

    //添加新的菜谱
    ResultBean addBook(EcCookbook cookbook);
    //添加新菜谱的详情
    ResultBean addBookContent(EcCookbook cookbook);
    //展示最新的四个菜谱（缩略图）
    ResultBean findNewBooks();
    //根据菜谱类型展示菜谱（缩略图）
    ResultBean findBooksByTid(String tid);
    //根据收藏者展示菜谱列表（缩略图）
    ResultBean findBooksByVid(Integer vid);
    //根据用户id展示发布的菜谱（缩略图）
    ResultBean findBooksByuid(Integer uid);
    //根据菜谱id查询菜谱
    ResultBean findBookBycid(String cid);
    //根据菜谱id删除菜谱
    ResultBean delBookByCid(Integer cid,Integer uid);
    //关注菜谱
    ResultBean collect(Integer cid,Integer uid);
    //取消关注
    ResultBean delcollect(Integer cid,Integer uid);
}
