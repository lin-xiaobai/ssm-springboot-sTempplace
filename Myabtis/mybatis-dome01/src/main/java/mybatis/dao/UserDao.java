package mybatis.dao;

import mybatis.pojo.user;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/13 -18:36
 * 增删改需要提交事务
 */
public interface UserDao {
//    使用注解来代替xml文件 （mybatis核心配置类xml文件(mybatis-config.xml) 中mapper需要指向于接口）
//    @Select(" select * from user.t_user")
//    获取所有人信息
    List<user> getUserList();
//    模糊查询 ：即查询字段值中含有相同的值 value:这里传的是字段值中相同的某些 字符串
    List<user> getUserListLike(String value);
//    删除
    boolean deleteUser(int id);

//    通过map查询指定的人
//   指定的那个人的（条件很多）即字段名很多
//   可以使用map集合 装那些条件字段名属性)  指定参数的类型为map集合
    user getUserByMap(Map<String,Object> map);
//    通过id查询个人
    user getUserById(int id);
//添加个人
    int addUser(user user);

//    通过id改
    int updateUser(user user);
//    修改 如果实体类中或者数据库中的表，字段参数过多的时候，可以设置为map集合
    int updateUsserByMap(Map<String,Object> map);
}
