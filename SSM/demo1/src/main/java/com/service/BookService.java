package com.service;


import com.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2021/10/21 -20:46
 */
public interface BookService {

    List<Book> queryAllBooks();

    Book queryBookById(int id);



}
