package mybatis.dao;

import mybatis.pojo.user;
import mybatis.utils.MybaticUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @date 2021/10/13 -21:00
 * 增删改需要提交事务
 */

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybaticUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
//          查询语句
            List<user> userList = mapper.getUserList();
            for (user user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            确保最后能关闭流
            if (sqlSession != null) sqlSession.close();

        }
    }

//    <!--    //    模糊查询 ：即查询字段值中含有相同的值 value:这里传的是字段值中相同的某些 字符串--
        @Test
        public void selectLike(){
            SqlSession sqlSession = MybaticUtils.getSqlSession();
            UserDao mapper = sqlSession.getMapper(UserDao.class);
//            两种模糊查询的方式：建议第二种防止sql注入
//            方式一
//            List<user> users = mapper.getUserListLike("%王%");
//            方式二：有效防止sql注入
            List<user> users = mapper.getUserListLike("王");
            for (user user: users) {
                System.out.println(user);
            }
        }
//    查询某个人(指定的条件很多) 即个人的字段名很多，可以指定类型为map类型
    @Test
    public void someperson(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("someperson",2);
        map.put("name","王五");
        user userByMap = mapper.getUserByMap(map);
        System.out.println(userByMap);

    }


//        第一步:获取sqlSession对象
//        SqlSession sqlSession = MybaticUtils.getSqlSession();
//        方式一：从sqlSession中的getMapper方法获取mapper对象 即接口类
//       执行sql
//
//        .class是反射，使用了动态代理（可以理解为一个new对象）这个比较灵活
//        .class可以获取本项目中的任意一个实体类的对象
//        getMapper 获取那个mapper因为mapper映射的是这个接口 所有返回的对象是一个接口
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
////        List<user> userList = mapper.getUserList();
////        for (user user :userList) {
////            System.out.println(user);
////        }
//////        关闭sqlSession
////        sqlSession.close();

    //        删除功能
    @Test
    public void delete() {
        SqlSession sqlSession1 = MybaticUtils.getSqlSession();
        UserDao mapper = sqlSession1.getMapper(UserDao.class);
        int id = 1;
        boolean delete1 = mapper.deleteUser(id);
        System.out.println(delete1);
        sqlSession1.commit();
        sqlSession1.close();
    }
//通过id查询个人
    @Test
    public void selectUser(){
        SqlSession sqlSession=MybaticUtils.getSqlSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        int id =1;
        user user = userDao.getUserById(id);
        System.out.println(user);
        sqlSession.close();
    }
//    添加个人
//    增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        user u1 = new user(2, "张三", "123");
        int i = mapper.addUser(u1);
        System.out.println(i);
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }
//    修改个人信息
    @Test
    public  void  updateUser(){
        SqlSession sqlSession=MybaticUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int user = mapper.updateUser(new user(2, "李四", "258"));
        System.out.println(user);
//        提交事务
        sqlSession.commit();
//        关闭流
        sqlSession.close();
    }
   //  修改，参数类型 为map,如果实体类中或者数据库中的表，字段参数过多的时候，可以设置为map集合-->
//   修改操作时，可以通过map集合保存只需要修改的值 ，而且#{username}里面username不需要与POJO类属性名一致
    @Test
    public void testUpdateMap(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","王五");
        map.put("userid",2);

//        传参为一个map集合时
        int i = mapper.updateUsserByMap(map);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }


}
