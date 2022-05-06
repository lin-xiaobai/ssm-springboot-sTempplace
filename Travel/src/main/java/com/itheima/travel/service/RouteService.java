package com.itheima.travel.service;

import com.github.pagehelper.PageInfo;
import com.itheima.travel.domain.Route;

/**
 * 线路的业务接口
 */
public interface RouteService {

    /**
     * 查询1页的线路
     * @param cid 分类id
     * @param pageNum 当前页
     * @param rname 线路名
     * 固定每页大小是3条记录
     */
    PageInfo<Route> findRouteByCid(int cid, int pageNum, String rname);

    /**
     * 将分类，线路，商家，线路图
     * 四张表的数据封装成一个Route对象
     */
    Route findRouteByRid(int rid);

    /**
     * 查询一条线路
     */
    Route findRoute(int rid);
}
