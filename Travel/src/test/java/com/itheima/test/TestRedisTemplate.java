package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.travel.dao.RouteDao;
import com.itheima.travel.domain.Category;
import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.CategoryService;
import com.itheima.travel.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private RouteService routeService;

    @Test
    public void testOps() {
        //简化对String类型的操作对象
        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        ops.set("company", "黑马");
        String company = ops.get("company");
        System.out.println(company);

        //设置过期的时间： 键，多久，单位
        redisTemplate.expire("company", 15, TimeUnit.SECONDS);
    }

    @Test
    public void testUser() {
        ValueOperations<String,Object> ops = redisTemplate.opsForValue();
        User user = new User();
        user.setUid(1);
        user.setUsername("张三");
        user.setPassword("234234234324");
        user.setSalt("2394usjdfl20934");
        user.setTelephone("15312345678");
        //将对象转成JSON
        ops.set("user", user);
        //将JSON转成对象
        User user1 = (User) ops.get("user");
        System.out.println(user1);
    }

    /**
     * 测试分类业务层
     */
    @Test
    public void testFindAllCategory() {
        List<Category> list = categoryService.findAll();
        list.forEach(System.out::println);
    }

    /**
     * 分页查询线路
     */
    @Test
    public void testFindPage() {
        //分页组件的使用。参数：第几页，每页大小
        PageHelper.startPage(2, 5);
        //自动生成2条SQL语句：查询总记录数，查询一页的数据。同时开启了mybatis的二级缓存，用来提高查询效率
        List<Route> routes = routeDao.findAll();

    }

    /**
     * 测试分页数据
     */
    @Test
    public void testFindRoute() {
        PageInfo<Route> pageInfo = routeService.findRouteByCid(5, 1, "双飞6天");
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("每页大小：" + pageInfo.getPageSize());
        System.out.println("这页数据：");
        List<Route> list = pageInfo.getList();
        list.forEach(System.out::println);
    }
}
