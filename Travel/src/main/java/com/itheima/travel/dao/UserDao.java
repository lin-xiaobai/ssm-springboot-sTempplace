package com.itheima.travel.dao;

import com.itheima.travel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 用户操作持久层
 */
public interface UserDao {

    /**
     * 通过用户名查询1个用户
     */
    @Select("select * from tab_user where username=#{username}")
    User findByUserName(String username);

    /**
     * 通过电话号码查询1个用户
     */
    @Select("select * from tab_user where telephone=#{telephone}")
    User findByTelephone(String telephone);

    /**
     * 添加用户
     */
    @Insert("insert into tab_user values(null,#{username},#{password},#{telephone},#{salt})")
    void save(User user);
}
