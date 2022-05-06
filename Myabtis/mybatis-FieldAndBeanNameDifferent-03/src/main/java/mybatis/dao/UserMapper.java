package mybatis.dao;

import mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/13 -18:36
 * 增删改需要提交事务
 */
public interface UserMapper {
//    使用注解来代替xml文件 （mybatis核心配置类xml文件(mybatis-config.xml) 中mapper需要指向于接口）
//    @Select(" select * from User.t_user")
//    获取所有人信息
    List<User> getUserList();
//    删除
    boolean deleteUser(int id);
//    通过id查询个人
    User getUserById(int id);
//添加个人
    int addUser(User user);
//    通过id改
    int updateUser(User user);

//    分页查询limit 需要传两个参数 所以可以使用map集合
    List<User> getUserByLimit(Map<String,Object> map);
}
