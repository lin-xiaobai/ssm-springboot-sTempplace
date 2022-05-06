通过注解来使用mybatis

1.注解在接口上实现（在方法上添加@Select(sql语句)
2.在核心配置文件中绑定接口
<mappers>
 <mapper class="mybatis.dao.UserMapper"/>
 </mappers>

 本质：反射机制
 底层：动态代理

 //    方法的形参位置如果存在多个参数，所有的基本类型参数前面必须加上@Param("参数名")
 //    所有的基本类型都需要，引用的对象就不用
POJO模型对象
 注意：如果是修改一个对象的话
 1.形参的位置是一个对象的话，sql语句中的字段名name，pwd， id 的#{}里面的值需要于对象里面的属性一致
 2.引用类型不用添加@Param{"名"}

 3.如果测试中有map集合的话，key必须是于@Param{"名"}里面的属性名一致 还有需要sql语句中key一致
  4.在sql中引用的就是我们这里的@Param{"名"}中设定的属性名
  @Update("update user.t_user set name=#{name},pwd=#{password} where id=#{id}")
     int updateUser(User user);

     #{}很大程度上防止sql注入
     ${}无法防止sql注入



Lombok插件
1.在idea中安装Lombox插件
2.在项目中导入lombox的jar包
3.在实体类上加注解