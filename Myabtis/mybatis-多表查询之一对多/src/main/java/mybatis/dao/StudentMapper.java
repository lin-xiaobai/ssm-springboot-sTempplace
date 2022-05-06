package mybatis.dao;

import mybatis.pojo.Student;

import java.util.List;

/**
 * @date 2021/10/16 -14:15
 */
public interface StudentMapper {
//    查询所有的学生属性，包括对应的老师的信息
//    方式一：按照 嵌套查询 （子查询）处理-->
    List<Student> getStudents();
//    方式二：按照结果集查询（关联表）处理
List<Student> getStudents2();
}
