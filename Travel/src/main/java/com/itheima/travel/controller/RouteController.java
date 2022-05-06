package com.itheima.travel.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.travel.domain.Route;
import com.itheima.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/route", produces = "application/json;charset=utf-8")
public class RouteController extends BaseController{

    @Autowired
    private RouteService routeService;
    /**
     * 查询1页的线路数据
     * 注：为了避免参数不正确，加个默认值
     */
    @RequestMapping("/findRouteListByCid")
    public PageInfo findRouteListByCid(@RequestParam(defaultValue = "5") Integer cid,
                                       @RequestParam(defaultValue = "3") Integer pageNum,
                                       @RequestParam(defaultValue = "") String rname) {
        return routeService.findRouteByCid(cid, pageNum, rname);
    }

    /**
     * 通过rid查询1条线路，封装了4张表的数据
     */
    @RequestMapping("/findRouteByRid")
    public Route findRouteByRid(int rid) {
        return routeService.findRouteByRid(rid);
    }
}
