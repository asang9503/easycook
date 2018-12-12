package com.eco.easycook.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eco.easycook.mapper.EcCollectMapper;
import com.eco.easycook.mapper.EcCookbookMapper;
import com.eco.easycook.pojo.EcCollect;
import com.eco.easycook.pojo.EcCookbook;
import com.eco.easycook.pojo.Material;
import com.eco.easycook.service.BookCookService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookCookServiceImpl implements BookCookService {

    @Autowired
    EcCookbookMapper bookMapper;
    @Autowired
    EcCollectMapper collectMapper;
    @Override
    public ResultBean addBook(EcCookbook cookbook) {
        int i =bookMapper.insertSelective(cookbook);
        int cid = cookbook.getEcId();
        return i>0?ResultUtil.setOK("添加成功",cid):ResultUtil.setMyError("添加失败");
    }

    @Override
    public ResultBean addBookContent(EcCookbook cookbook) {
        return null;
    }

    @Override
    public ResultBean findNewBooks() {
        List<EcCookbook> books= bookMapper.selectByLimit(4);
        return books!=null?ResultUtil.setOK("最新美食",books):ResultUtil.setMyError("展示失败");
    }

    @Override
    public ResultBean findBooksByTid(String tid) {
        if (tid==null){

            return ResultUtil.setMyError("展示失败");
        }else {
            List<EcCookbook> books= bookMapper.selectByType(Integer.valueOf(tid));
            return ResultUtil.setOK("根据类型查找美食",books);
        }


    }
    //查看我收藏的菜谱
    @Override
    public ResultBean findBooksByVid(Integer vid) {

            List<EcCookbook> books = bookMapper.selectByVid(vid);
            return ResultUtil.setOK("查看我的收藏", books);

    }
    @Override
    public ResultBean findBooksByuid(Integer uid) {

        List<EcCookbook> books = bookMapper.selectByUid(uid);
        return ResultUtil.setOK("查看我的发布", books);
    }

    @Override
    public ResultBean findBookBycid(String cid) {
        if (cid==null){

            return ResultUtil.setMyError("展示失败");
        }else {
            Map<String,Object> map= bookMapper.selectByCid(Integer.valueOf(cid));

            List<Material> list = JSONArray.parseArray((String) map.get("ecMaterial"),Material.class);
            List<Material> list2 = JSONArray.parseArray((String) map.get("ecContent"),Material.class);
            map.put("ecMaterial",list);
            map.put("ecContent",list2);
            return ResultUtil.setOK("展示菜谱详情",map);
        }
    }

    @Override
    public ResultBean delBookByCid(Integer cid,Integer uid) {
        //删除根据菜谱id删除关注

        return ResultUtil.execOp(bookMapper.delByPrimaryKey(cid,uid),"删除菜谱");
    }

    @Override
    public ResultBean collect(Integer cid, Integer uid) {

        EcCollect collect=new EcCollect();
        collect.setEcCid(cid);
        collect.setEcVid(uid);
        return ResultUtil.execOp(collectMapper.insert(collect),"关注菜谱");
    }

    @Override
    public ResultBean delcollect(Integer cid, Integer uid) {
        EcCollect collect=new EcCollect();
        collect.setEcCid(cid);
        collect.setEcVid(uid);
        return ResultUtil.execOp(collectMapper.delBycidAndUid(collect),"取消关注菜谱");
    }
}
