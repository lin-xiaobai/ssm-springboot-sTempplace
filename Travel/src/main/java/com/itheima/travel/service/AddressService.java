package com.itheima.travel.service;

import com.itheima.travel.domain.Address;

import java.util.List;

/**
 * 收货人地址业务层
 */
public interface AddressService {

    /**
     * 查询某个用户收货人地址
     * @param uid
     * @return
     */
    List<Address> findByUid(int uid);

    /**
     * 查询aid对应的收货地址
     */
    Address findByAid(int aid);
}
