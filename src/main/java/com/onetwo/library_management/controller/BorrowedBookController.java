package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.BorrowedBook;
import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.service.BookService;
import com.onetwo.library_management.service.BorrowedBooksService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
@AllArgsConstructor
public class BorrowedBookController {
    private final BorrowedBooksService borrowedBooksService;
    private final BookService booksService;


    @GetMapping("/book/borrowBook/{id}")
    public String showBorrowForm(@PathVariable("id") Long bookId, Model model) {
        // get book
        Book book = booksService.findBookById(bookId);

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);

        // set start end dates
        Calendar today = Calendar.getInstance();
        borrowedBook.setStartDate(today.getTime());
        today.add(Calendar.MONTH, 1);
        borrowedBook.setEndDate(today.getTime());

        model.addAttribute("borrowed_book", borrowedBook);
        return "borrow-book";
    }

    @RequestMapping("/book/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long bookId, BorrowedBook borrowedBook, BindingResult result, Model model) {
        if (result.hasErrors()) {return "borrow-book";}
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Book book = booksService.findBookById(bookId);
        borrowedBook.setBook(book);


        // get logged in user
        User user = (User) auth.getPrincipal();
        borrowedBook.setUser(user);

        System.out.println(borrowedBook.getBook());
        System.out.println(borrowedBook.getUser());
        System.out.println(borrowedBook.getStartDate());
        System.out.println(borrowedBook.getEndDate());

        borrowedBooksService.createBorrowedBook(borrowedBook);
        return "redirect:/books";
    }

}
