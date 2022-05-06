package com.itheima.travel.service;

import com.itheima.travel.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有的分类
     */
    List<Category> findAll();
}
