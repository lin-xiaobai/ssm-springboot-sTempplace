package com.service.impl;

import com.dao.UserMapper;
import com.domain.ResultInfo;
import com.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.utils.Md5Utils;
import com.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2021/10/23 -17:05
 */
@Service
public class UserServiceImpl implements UserService {
//   注入usermapper
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultInfo register(User user) {
        User user1 = userMapper.selectByName(user.getName());
        if (user1 != null) {
            return new ResultInfo(false,"用户已经存在");
        }
        User user2 = userMapper.selectByTelephone(user.getTelephone());
        if (user2!=null){
            return  new ResultInfo(false,"用户电话已存在");
        }
//        新用户
//        对密码加密 密码=用户名+uuid+密码
        String uuid = UuidUtils.getUUID();
        String md5 = Md5Utils.getMd5(user.getName() + user.getPassword() + uuid);
//        替换原来的密码
        user.setPassword(md5);
//        将uuid传给user对象的slat属性
        user.setSlat(uuid);
        int i = userMapper.saveUser(user);
        return new ResultInfo(true,"用户注册成功");
    }

    @Override
    public List<User> selectByLimit() {
        return userMapper.selectByLimte();
    }

    @Override
    public List<User> findAllUserByPageF(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.selectByLimte();
        return lists;
    }

    @Override
    public PageInfo<User> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.selectByLimte();
        PageInfo<User> pageInfo = new PageInfo<User>(lists);
        return pageInfo;
    }
}
