package com.itheima.travel.service.impl;

import com.itheima.travel.dao.AddressDao;
import com.itheima.travel.domain.Address;
import com.itheima.travel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;
    /**
     * 查询某个用户收货人地址
     * @param uid
     * @return
     */
    @Override
    public List<Address> findByUid(int uid) {
        return addressDao.findByUid(uid);
    }

    /**
     * 查询aid对应的收货地址
     * @param aid
     */
    @Override
    public Address findByAid(int aid) {
        return addressDao.findByAid(aid);
    }
}
