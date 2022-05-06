package mybatis.dao;

import mybatis.dao.TeacherMapper;
import mybatis.pojo.Teacher;
import mybatis.utils.MybaticUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * @date 2021/10/16 -14:28
 */
public class test {
    @Test
    public void testTeachers() {
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teaches = mapper.getTeaches();
        for (Teacher teach : teaches) {
            System.out.println(teach);
        }
        sqlSession.close();
    }
//    <!--    按照结果嵌套查询-->
    @Test
    public void testTeachers2() {
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherById = mapper.getTeacherById(1);
        System.out.println(teacherById);
        sqlSession.close();
    }
//  <!--    按照查询嵌套查询-->
@Test
        public void testTeachers3() {
    SqlSession sqlSession = MybaticUtils.getSqlSession();
    TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
    Teacher teacherById = mapper.getTeacherById3(1);
    System.out.println(teacherById);
    sqlSession.close();
}
}
