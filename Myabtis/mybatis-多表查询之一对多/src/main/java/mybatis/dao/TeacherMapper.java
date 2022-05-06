package mybatis.dao;

import mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2021/10/16 -14:15
 * Teacher(id=1, name=秦老师, student=null) 控制台打印结果
 */
public interface TeacherMapper {
    //    获取所有的老师（包括老师下的学生）
    List<Teacher> getTeaches();

//  获取指定老师下的所有学生以及老师的信息
//    问题：解决Teacher(id=1, name=秦老师, student=null)
//    学生对象为空的问题 如何将数据库中的学生表 与 教师表 联合查询
//    <!--   方式一： 按照结果嵌套查询-->
    Teacher getTeacherById(@Param("id")int id);
//    <!--   方式二：按照查询嵌套查询-->
    Teacher getTeacherById3(@Param("id")int id);
}
