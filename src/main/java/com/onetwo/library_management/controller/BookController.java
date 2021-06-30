package com.onetwo.library_management.controller;

import com.onetwo.library_management.model.Book;
import com.onetwo.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService accountService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return accountService.getBooks();
    }
}
