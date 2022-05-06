package mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @date 2021/10/13 -18:32
 */
//为类名起别名
//    @Alias("User")
//    数据库中的pwd字段名与User类中的password属性名不一样
//实体类
//    lombok插件：自动生成set和get方法等等
    @Data
    @NoArgsConstructor//无参加构造
    @AllArgsConstructor//有参构造
    @ToString

public class User {
    private int id;
    private String name;

    private String password;
}
