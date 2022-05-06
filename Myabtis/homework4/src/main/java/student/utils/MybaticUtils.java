package student.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @date 2021/10/13 -18:14
 * 这个工具类的作用 是来通过SqlSessionFactory类获取SqlSession对象
 * SqlSession 提供了在数据库执行 SQL 命令所需的所有方法
 */

public class MybaticUtils {
    private  static SqlSessionFactory sqlSessionFactory;
    static{
//        在初始化的时候获取maven工程的mybatis的核心xml文件
//         使用mybatis框架 获取 SqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

