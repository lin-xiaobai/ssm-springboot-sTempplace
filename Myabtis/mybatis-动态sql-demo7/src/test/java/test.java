import mybatis.dao.BlogMapper;
import mybatis.pojo.blos;
import mybatis.utils.IdUtils;
import mybatis.utils.MybaticUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @date 2021/10/17 -12:32
 */
public class test {
    @Test
    public void insertBlosByAnnotation(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        String uuId = IdUtils.getUUId();
        blos blos = new blos(uuId, "Python", "李三", new Date(), 9999);
        mapper.addbolos(blos);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void insertBlosByXML() {
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        String uuId = IdUtils.getUUId();
        blos blos = new blos(uuId, "jquery", "李三", new Date(), 1000);
        mapper.insertBlos(blos);
        blos bloss = new blos(IdUtils.getUUId(), "js", "李三", new Date(), 9999);
        mapper.insertBlos(bloss);
        sqlSession.commit();
        sqlSession.close();
    }
//    测试xml文件中if标签
    @Test
    public void selectBlosByifaddwhere(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        当map集合中没有值时，则在BlogMapper.xml文件中没有sql拼接，则是查询全部
//        Map map=new HashMap();
//        拼接sql语句，添加一个条件 即 title=java
          Map map=new HashMap();
//          map.put("title","java");
//        添加2个条件 第一：title=java 和author=张三
        map.put("title","java");
        map.put("author","张三");
        List<blos> blos = mapper.selectBlossByIF(map);
        for (blos blo : blos) {
            System.out.println(blo);
        }
        sqlSession.close();
    }
//    多个条件中选择一个去拼接sql语句  choose标签
//    类似于java中 switch 语句
//    测试xml文件中choose标签
        @Test
        public void selectBlosByChoose() {
            SqlSession sqlSession = MybaticUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map map = new HashMap();
//            由于标签是choose标签只能选择其中一个
            map.put("title", "java");
            map.put("views",9999);
            List<blos> blos = mapper.selectBlossByChoose(map);
            for (blos blo : blos) {
                System.out.println(blo);
            }
            sqlSession.close();

        }
//        <!--    修改 使用set标签-->
//<!--    用于动态更新语句的类似解决方案叫做 set。
//    set 元素可以用于动态包含需要更新的列，忽略其它不更新的列-->
//<!--set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号-->
//<!--（这些逗号是在使用条件语句给列赋值时引入的-->
    @Test
    public void updateBySet(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        map.put("title", "java");
        map.put("id","18c76a6d46fa4f37aea6f8b109ca504d");
        map.put("views",2);
        mapper.updateBlosBySet(map);
        sqlSession.commit();
        sqlSession.close();
    }
//    测试mapper.xml文件中sql标签
    @Test
    public void test(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        map.put("title","java");
        List<blos> blos = mapper.selectBlossByIF(map);
        for (blos blo : blos) {
            System.out.println(blo);
        }

    }

    //    测试mapper.xml文件中foreach标签
//    查询id为1，2,3的数据并且将讲id的数据存储在集合中，
//    在mapper.xml文件中使用foreach遍历集合获取集合中的值，然后进行拼接sql语句
    @Test
    public void testforeach() {
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        因为foreach标签中需要传递一个集合类型，
//        将需要查询的id数据存储在集合中，
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        Map map = new HashMap();
//        将list集合存储在map集合中，并且命名为ids(Mapper.xml文件的foreach里面的collection的值 为ids)
        map.put("ids", list);

        List<blos> blos = mapper.selectBlossByForeach(map);
        for (mybatis.pojo.blos blo : blos) {
            System.out.println(blo);
        }
    }

    }
