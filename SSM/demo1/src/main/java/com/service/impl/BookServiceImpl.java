package com.service.impl;

import com.dao.BookMapper;
import com.domain.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2021/10/21 -20:41
 */
//@Service,@Repository不能写在接口上,需要写在接口的实现类上。
    @Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> queryAllBooks() {
        List<Book> books = bookMapper.queryAllBooks();
        return  books;
    }

    @Override
    public Book queryBookById(int bookID) {
        return bookMapper.queryByID(bookID);
    }

}

