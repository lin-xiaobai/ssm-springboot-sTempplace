package mybatis.dao;

import mybatis.pojo.Teacher;

import java.util.List;

/**
 * @date 2021/10/16 -14:15
 */
public interface TeacherMapper {
//    获取所有的老师
    List<Teacher> getTeaches();
}
