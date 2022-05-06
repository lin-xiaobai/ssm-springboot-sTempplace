package com.dao;

import com.domain.img;
import org.apache.ibatis.annotations.Select;

/**
 * @date 2021/10/26 -14:44
 */
public interface ImgMapper {
    @Select("select * from image where id = #{id}")
    img selectImg(int id);
}
