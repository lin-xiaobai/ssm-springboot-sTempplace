package com.controller;


import com.domain.Book;
import com.service.BookService;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @date 2021/10/21 -20:38
 */
@Controller
public class BookContoller {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public  String  index(){
        return "index1";
    }

    @RequestMapping(value = "/book/all",method = RequestMethod.GET)
    public String test(Model model){
        List<Book> books = bookService.queryAllBooks();
        model.addAttribute("books", books);
        return "success";
    }

    @RequestMapping(value = "/book/id",method = RequestMethod.POST)
    public  String id(@RequestParam("bookID") int bookID, Model model){
        Book book =bookService.queryBookById(bookID);
        model.addAttribute("bookID",book);
        return "success";

    }
}
