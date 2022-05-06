package mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @date 2021/10/16 -14:10
 */
//实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    private int id;
    private String name;
//    一个老师有多个学生，集合
//    需要在这里设置一个属性 指向学生对象
    private List<Student> students;
}
