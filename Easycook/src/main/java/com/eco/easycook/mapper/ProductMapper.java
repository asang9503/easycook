package com.eco.easycook.mapper;

import com.eco.easycook.pojo.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer ecGid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer ecGid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}