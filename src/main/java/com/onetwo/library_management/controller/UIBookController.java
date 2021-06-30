package com.onetwo.library_management.controller;


import com.onetwo.library_management.model.Book;
import com.onetwo.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/book")
public class UIBookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView("books"); // i.e books.jsp
        List<Book> books = bookService.getBooks();
        System.out.println(books);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("new-book-form") Book book, ModelMap model) {
        bookService.saveBook(book);
        List<Book> books = bookService.getBooks();

        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping(value = "/details/{bookId}", method = RequestMethod.GET)
    public ModelAndView accountDetail(@PathVariable("bookId") String id) {
        Book book = bookService.getBookById(id);
        ModelAndView modelAndView = new ModelAndView("bookDetails"); //i.e accountDetail.jsp

        modelAndView.addObject("book", book);
        return modelAndView;
    }

    // todo: add more views

}
