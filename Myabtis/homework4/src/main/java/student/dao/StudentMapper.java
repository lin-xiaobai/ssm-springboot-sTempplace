package student.dao;

import org.apache.ibatis.annotations.Select;
import student.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/12/5 -16:34
 */
public interface StudentMapper {

//    查全部
    @Select("select * from student")
    List<Student> selectAll();
//    通过条件查
   List<Student> selectStudent(Map map);
//    增加一个学生
    int insertStudent(Student student);


}
