package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.BorrowStatus;
import com.onetwo.library_management.entity.BorrowedBook;
import com.onetwo.library_management.service.BookService;
import com.onetwo.library_management.service.BorrowedBooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminBorrowedBookController {
    private final BorrowedBooksService borrowedBooksService;
    private final BookService bookService;


    @RequestMapping("/admin/all_borrows")
    public String findAllBorrowedBooks(Model model) {
        final List<BorrowedBook> borrowedBooks = borrowedBooksService.findAllBorrowedBooks();

        model.addAttribute("borrowed_books", borrowedBooks);
        return "list-borrows";
    }

    @RequestMapping("/admin/borrows/return/{id}")
    public String processBorrowedBook(@PathVariable("id") Long borrowId, Model model) {
        BorrowedBook borrowedBook = borrowedBooksService.findBorrowedBookById(borrowId);
        // update borrowed book record
        borrowedBook.setStatus(BorrowStatus.RETURNED);
        borrowedBooksService.updateBorrowedBook(borrowedBook);

        // update book
        Book book = borrowedBook.getBook();
        book.setLeftInStock(book.getLeftInStock() + 1);
        bookService.updateBook(book);
        final List<BorrowedBook> borrowedBooks = borrowedBooksService.findAllBorrowedBooks();

        model.addAttribute("borrowed_books", borrowedBooks);
        return "redirect:/admin/all_borrows";
    }

}
