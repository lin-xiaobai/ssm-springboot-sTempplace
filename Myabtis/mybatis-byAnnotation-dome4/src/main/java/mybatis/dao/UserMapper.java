package mybatis.dao;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/13 -18:36
 * 增删改需要提交事务
 */
public interface UserMapper {
//    使用注解来代替xml文件 （mybatis核心配置类xml文件(mybatis-config.xml) 中mapper需要指向于接口）
    @Select("select * from user.t_user")
//    获取所有人信息
    List<User> getUserList();
//    删除
    @Delete("delete from user.t_user where id= #{id}")
    boolean deleteUser(int id);
//    通过id查询个人
//    方法的形参位置如果存在多个参数，所有的参数前面必须加上@Param("参数名")
//    所有的基本类型都需要，引用的对象就不用
//  @Param("id")里面的值需要与sql语句中#{id}一致 ，不用与形参的属性名一致
    @Select("select * from user.t_user where id=#{id}")
    User getUserById(@Param("id") int id);
//添加个人
//    value后面的@{属性名} 属性名需要与形参位置的对象的属性名一致 3
//    引用类型不用添加@Param("属性名")
    @Insert("insert into user.t_user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);
//    通过id改//    value后面的@{属性名} 属性名需要与形参位置的对象的属性名一致 3
    @Update("update user.t_user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

//    分页查询limit 需要传两个参数 所以可以使用map集合
    List<User> getUserByLimit(Map<String, Object> map);
}
