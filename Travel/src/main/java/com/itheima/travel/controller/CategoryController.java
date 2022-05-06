package com.itheima.travel.controller;

import com.itheima.travel.domain.Category;
import com.itheima.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/category", produces = "application/json;charset=utf-8")
public class CategoryController extends BaseController{

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有的分类
     */
    @RequestMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
