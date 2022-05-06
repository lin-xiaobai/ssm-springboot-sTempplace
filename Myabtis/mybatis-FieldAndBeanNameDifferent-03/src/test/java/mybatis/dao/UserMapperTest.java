package mybatis.dao;

import Log4j.testLog4j;
import mybatis.pojo.User;
import mybatis.utils.MybaticUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @date 2021/10/13 -21:00
 * 增删改需要提交事务
 */

public class UserMapperTest {
    static Logger logger=Logger.getLogger(testLog4j.class);
    @Test
    public void test() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybaticUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            logger.error(mapper);
//          查询语句
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            确保最后能关闭流
            if (sqlSession != null) sqlSession.close();

        }
    }
    //        删除功能
    @Test
    public void delete() {
        SqlSession sqlSession1 = MybaticUtils.getSqlSession();
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
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
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        int id =3;
        User user = userMapper.getUserById(id);
        System.out.println(user);
        sqlSession.close();
    }
//    添加个人
//    增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u1 = new User(2, "张三", "123");
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(2, "李四", "258"));
        System.out.println(user);
//        提交事务
        sqlSession.commit();
//        关闭流
        sqlSession.close();
    }
//    分页查询
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Object> map=new HashMap<>();
//        map中的key需要与sql语句中${名} 的名一致才能对应成功
        map.put("startIndex",1);
        map.put("pageSize",4);
        List<User> users = mapper.getUserByLimit(map);
        for (User user:users) {
            System.out.println(user);
        }
        sqlSession.close();

    }
}
