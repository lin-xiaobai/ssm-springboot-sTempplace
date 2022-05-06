package mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @date 2021/10/17 -11:57
 */
@Data//自动设置set和get方法等等
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class blos {
    private String id;
    private String title;
    private String author;
//    数据库中createTime的字段类型为create-time,
//    但实体类中的属性名为createTime（驼峰命名法）
//    解决方法：在核心配置文件中设置 mybatis中内置的settings(调整设置)会改变 MyBatis 的运行时行为
//    mapUnderscoreToCamelCase设置为true的时候开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn。
    private Date createTime;
    private int views;

}
