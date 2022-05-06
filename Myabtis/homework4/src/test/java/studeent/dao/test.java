package studeent.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import student.dao.StudentMapper;
import student.pojo.Student;
import student.utils.MybaticUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2021/12/5 -16:45
 */
public class test {
//    查询所有学生
    @Test
    public  void selectAllTest(){
//        从工具类获取sqlsession对象
        SqlSession sqlSession = MybaticUtils.getSqlSession();
//        创建mapper对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        调用方法查询所有
        List<Student> students = mapper.selectAll();
//        遍历list集合
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void selectOneTest(){
        SqlSession sqlSession = MybaticUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map map=new HashMap();
//        map.put("sname","22");
//        map.put("sage",33);
        map.put("sid","201955333731");
        List<Student> student = mapper.selectStudent(map);
        System.out.println(student);
    }

    /**
     * 增加功能
     */
    @Test
    public  void  insertUser(){
//        通过工具类获取sqlSession对象
        SqlSession sqlSession = MybaticUtils.getSqlSession();
//        获取mapper对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        创建学生对象
        Student student=new Student();
//        设置学生属性
        student.setSname("name");student.setSid("201955333732");
        student.setSage(19);student.setScolleage("nnn");
        student.setSmajor("计算机");
        //    定义一个标识，默认是不可以执行添加学生操作
        boolean flag=false;
        Map map=new HashMap();
        map.put("sid",student.getSid());
//        根据学生学号查是否存在
        List<Student> students = mapper.selectStudent(map);
        if(students.size()>=1){
            flag=false;
            System.out.println("学生的学号已存在");
        }else{
            flag=true;
        }
        if(flag) {
            int i = mapper.insertStudent(student);
            if(i>0){
                System.out.println("数据存入成功");
            }else{
                System.out.println("数据存入失败");
            }
        }
    }
}
