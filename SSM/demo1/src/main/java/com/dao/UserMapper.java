package com.dao;

import com.domain.User;
import okhttp3.Route;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/23 -16:45
 */
public interface UserMapper {

//    通过传参为map，指定查询的数据库的字段名
    User selectByIf(Map map);

//    根据name和telephone查询
    User selectByName(String name);
    User selectByTelephone(String telephone);

//    插入语句
    int saveUser(User user);

//    分页查询
    @Select("select * from user")
    List<User> selectByLimte();

}
