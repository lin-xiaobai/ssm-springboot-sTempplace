package mybatis.dao;

import mybatis.pojo.blos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/17 -12:12
 */
public interface BlogMapper {


    blos selectBloss(@Param("id") int id);

}
