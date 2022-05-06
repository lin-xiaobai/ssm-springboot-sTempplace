package com.itheima.travel.dao;

import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.RouteImg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 线路表
 */
public interface RouteDao {

    /**
     * 查询所有的线路
     */
    @Select("SELECT * FROM tab_route")
    List<Route> findAll();

    /**
     * 查询某个分类下所有的线路
     */
    List<Route> findRouteByCid(@Param("cid") int cid, @Param("rname") String rname);


    /**
     * 查询指定rid的1条线路，包含了3张表的数据：分类，线路，商家
     * 键：表字段名，值：字段对应的值
     */
    @Select("select * from tab_category c inner join tab_route r on c.cid=r.cid inner join tab_seller s on r.sid = s.sid where rid=#{rid}")
    Map<String, Object> findRouteByRid(int rid);

    /**
     * 查询指定rid线路对应的所有图片
     */
    @Select("select * from tab_route_img where rid=#{rid}")
    List<RouteImg> findRouteImgsByRid(int rid);

    /**
     * 通过rid查询一条线路
     */
    @Select("select * from tab_route where rid=#{rid}")
    Route findRoute(int rid);
}
