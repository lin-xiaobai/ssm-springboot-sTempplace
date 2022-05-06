package com.itheima.travel.dao;

import com.itheima.travel.domain.Address;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 收货地址
 */
public interface AddressDao {

    /**
     * 获取某个用户所有收货地址
     */
    @Select("select * from tab_address where uid=#{uid}")
    List<Address> findByUid(int uid);

    /**
     * 查询aid对应的收货地址
     */
    @Select("select * from tab_address where aid=#{aid}")
    Address findByAid(int aid);
}
