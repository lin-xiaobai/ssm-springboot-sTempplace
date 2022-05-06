package com.service;

import com.domain.ResultInfo;
import com.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @date 2021/10/23 -17:05
 */
public interface UserService {
//    注册
    ResultInfo register(User user);
//    分页查询
    List<User> selectByLimit();

    List<User> findAllUserByPageF(int pageNum,int pageSize);
    PageInfo<User> findAllUserByPageS(int pageNum, int pageSize);

}
