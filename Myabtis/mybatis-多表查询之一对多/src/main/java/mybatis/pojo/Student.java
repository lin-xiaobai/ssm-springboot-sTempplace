package mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @date 2021/10/13 -18:32
 */
//为类名起别名
//实体类
//    lombok插件：自动生成set和get方法等等
    @Data
    @NoArgsConstructor//无参加构造
    @AllArgsConstructor//有参构造
    @ToString
public class Student {
    private int id;
    private String name;
    private int tid;

}
