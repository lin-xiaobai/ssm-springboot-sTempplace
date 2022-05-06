package com.itheima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.travel.dao.RouteDao;
import com.itheima.travel.domain.Category;
import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.RouteImg;
import com.itheima.travel.domain.Seller;
import com.itheima.travel.service.RouteService;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    /**
     * 查询1页的线路
     * @param cid 分类id
     * @param pageNum 当前页
     */
    @Override
    public PageInfo<Route> findRouteByCid(int cid, int pageNum, String rname) {
        //1.设置分页
        PageHelper.startPage(pageNum, 3);  //每页显示3条记录
        //2.调用dao来查询
        List<Route> routes = routeDao.findRouteByCid(cid, rname);
        //3.封装成PageInfo对象
        PageInfo pageInfo = new PageInfo(routes);  //通过构造方法封装数据
        return pageInfo;
    }

    /**
     * 将分类，线路，商家，线路图
     * 四张表的数据封装成一个Route对象
     * @param rid
     */
    @Override
    @SneakyThrows
    public Route findRouteByRid(int rid) {
        //查询三张表的数据
        Map<String, Object> map = routeDao.findRouteByRid(rid);
        //创建分类和商家对象，并且复制属性
        Category category = new Category();
        BeanUtils.populate(category, map);  //只会复制同名的属性
        Seller seller = new Seller();
        BeanUtils.populate(seller, map);
        //创建Route对象，封装其它三张表的属性值
        Route route = new Route();
        BeanUtils.populate(route, map);
        //封装分类
        route.setCategory(category);
        //封装商家
        route.setSeller(seller);
        //查询数据库得到图片集合
        List<RouteImg> imgList = routeDao.findRouteImgsByRid(rid);
        route.setRouteImgList(imgList);
        return route;
    }

    /**
     * 查询一条线路
     * @param rid
     */
    @Override
    public Route findRoute(int rid) {
        return routeDao.findRoute(rid);
    }
}
