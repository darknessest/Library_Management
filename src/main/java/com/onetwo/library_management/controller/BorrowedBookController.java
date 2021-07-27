package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.BorrowStatus;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public String borrowBook(@PathVariable("id") Long bookId, BorrowedBook borrowedBook, BindingResult result) {
        if (result.hasErrors()) {
            return "borrow-book";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Book book = booksService.findBookById(bookId);

        if (book.getLeftInStock() > 0) {
            // update left in stock value
            book.setLeftInStock(book.getLeftInStock() - 1);
            booksService.updateBook(book);

            borrowedBook.setBook(book);

            // get logged in user
            User user = (User) auth.getPrincipal();
            borrowedBook.setUser(user);


            borrowedBooksService.createBorrowedBook(borrowedBook);
        }
        return "redirect:/books";
    }


    @GetMapping("/user/borrows")
    public String showUserBorrows(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        List<BorrowedBook> borrowedBooks = borrowedBooksService.findBorrowedBooksByUserId(user.getId());
        model.addAttribute("borrowed_books", borrowedBooks);
        return "list-user-borrows";
    }

    @RequestMapping("/book/borrow/postpone/{id}")
    public String postponeBorrowBook(@PathVariable("id") Long borrowId, Model model) {
        BorrowedBook borrowedBook = borrowedBooksService.findBorrowedBookById(borrowId);

        if (borrowedBook.getStatus() != BorrowStatus.POSTPONED || borrowedBook.getStatus() != BorrowStatus.PROCESSED) {

            // todo: add check if it's the same user
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) auth.getPrincipal();
            borrowedBook.setStatus(BorrowStatus.POSTPONED);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(borrowedBook.getEndDate());

            // todo: add checks endDate is not further than 2 months from startDate
            endCalendar.add(Calendar.WEEK_OF_MONTH, 1);
            borrowedBook.setEndDate(endCalendar.getTime());

            borrowedBooksService.updateBorrowedBook(borrowedBook);
            model.addAttribute("borrowed_books", borrowedBooksService.findAllBorrowedBooks());

        }
        return "redirect:/user/borrows";
    }

    @RequestMapping("/book/borrow/return/{id}")
    public String returnBorrowBook(@PathVariable("id") Long borrowId, Model model) {
//        if (result.hasErrors()) {
//            return "borrow-book";
//        }
        BorrowedBook borrowedBook = borrowedBooksService.findBorrowedBookById(borrowId);
        if (borrowedBook.getStatus() != BorrowStatus.RETURNED || borrowedBook.getStatus() != BorrowStatus.PROCESSED) {
            Calendar today = Calendar.getInstance();
            borrowedBook.setEndDate(today.getTime());
            borrowedBook.setStatus(BorrowStatus.PROCESSED);
            borrowedBooksService.updateBorrowedBook(borrowedBook);

            model.addAttribute("borrowed_books", borrowedBooksService.findAllBorrowedBooks());
        }
        return "redirect:/user/borrows";
    }

}
