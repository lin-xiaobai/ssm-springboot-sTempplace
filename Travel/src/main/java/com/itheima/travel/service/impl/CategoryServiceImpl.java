package com.itheima.travel.service.impl;

import com.itheima.travel.dao.CategoryDao;
import com.itheima.travel.domain.Category;
import com.itheima.travel.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    //使用Redis
    @Autowired
    private RedisTemplate<String,List<Category>> redisTemplate;

    /**
     * 查询所有的分类
     */
    @Override
    public List<Category> findAll() {
        //1.从Redis中获取导航分类
        ValueOperations<String,List<Category>> ops = redisTemplate.opsForValue();
        //2.获取分类集合
        List<Category> categories = ops.get("categories");
        //判断是否为空
        if (categories == null) {
            //redis中没有，从mysql读取数据
            log.info("从MySQL中获取导航分类");
            categories = categoryDao.findAll();
            //放到redis中
            ops.set("categories", categories);
        }
        else {
            log.info("从Redis中获取导航分类");
        }
        return categories;
    }
}
