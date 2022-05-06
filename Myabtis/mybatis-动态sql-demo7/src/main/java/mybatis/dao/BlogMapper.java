package mybatis.dao;

import mybatis.pojo.blos;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/17 -12:12
 */
public interface BlogMapper {
//    通过注解添加
//    添加在注解上添加
    @Insert("insert into blog (id,title,author,create_time,views) values(#{id},#{title},#{author},#{createTime},#{views})")
    int addbolos(blos blos);
//    通过xml文件添加
    int insertBlos(blos blos);

//    形参位置多个属性名使用map集合
//    通过 “title” 和 “author” 两个参数进行可选搜索
//    在xml文件中的select标签 里面填写 一个if标签 表示可选搜索
    List<blos> selectBlossByIF(Map map);

//    想从多个条件中选择一个使用去拼接sql语句
//MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句
    List<blos> selectBlossByChoose(Map map);

//    更新，修改
//    使用set标签
//    用于动态更新语句的类似解决方案叫做 set标签
//set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号
// （这些逗号是在使用条件语句给列赋值时引入的
    int updateBlosBySet(Map map);


//    在sql语句里面 使用foreach标签
//   在sql语句中 对集合进行遍（尤其是在构建 IN 条件语句的时候遍历集合 ，即可查询不同条件的数据
//    查询id 为1,2,3的数据
//    传参为 map集合
    List<blos> selectBlossByForeach(Map map);

}
