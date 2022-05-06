package com.dao;

import com.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/21 -19:51
 */
public interface BookMapper {
//    @Insert("insert into books('bookName','bookCounts','detail') values (#{bookName},#{bookCounts},#{details})")
//    void addBook(Book book);
//    @Delete("delete from books where bookId = #{id}")
//    int deleteBookById(@Param("id") Integer id);
//    @Update(" update books set 'bookName' = #{bookName},'bookCounts' = #{bookCounts},'detail' = #{detail} where 'bookId' = #{bookId}")
//    int updateBook(Book book);
//
//    Book queryBookById(@Param("id") Integer id);
//    查询全部
    List<Book> queryAllBooks();
//    根据id查全部
    Book queryByID(@Param("bookID") int bookID);
}
