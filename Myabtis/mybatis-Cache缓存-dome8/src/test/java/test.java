import mybatis.dao.BlogMapper;
import mybatis.pojo.blos;
import mybatis.utils.MybaticUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @date 2021/10/20 -12:10
 */
public class test {
    @Test
    public void sl(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//       在同一个sqlsession对象下 第一次查询的结果交给了 一级缓冲，
//       第二次查询id是直接先访问一级缓冲 ，如果有则直接取，如果没有则需要进行数据访问
        blos blos = mapper.selectBloss(1);


//        手动清除缓存
        sqlSession.clearCache();

        blos blos2 = mapper.selectBloss(1);
        System.out.println(blos==blos2);
        sqlSession.close();



    }
}
