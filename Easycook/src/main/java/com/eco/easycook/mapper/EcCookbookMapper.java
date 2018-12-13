package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcCookbook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "EcCookbookMapper")
public interface EcCookbookMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcCookbook record);

    int insertSelective(EcCookbook record);
    //查询菜谱详情
    EcCookbook selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcCookbook record);

    int updateByPrimaryKey(EcCookbook record);

    List<EcCookbook> selectByLimit(Integer pagecount);

    List<EcCookbook> selectByType(Integer typeid);

    List<EcCookbook> selectByVid(Integer vid);

    List<EcCookbook> selectByUid(Integer uid);

    Map<String,Object> selectByCid(Integer cid);

    int delByPrimaryKey(@Param("cid") Integer cid,@Param("uid") Integer uid);


}