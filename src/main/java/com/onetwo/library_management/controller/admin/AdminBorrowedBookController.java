package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.BorrowedBook;
import com.onetwo.library_management.service.BorrowedBooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminBorrowedBookController {
    private final BorrowedBooksService borrowedBooksService;


    @RequestMapping("/admin/all_borrows")
    public String findAllBorrowedBooks(Model model) {
        final List<BorrowedBook> borrowedBooks = borrowedBooksService.findAllBorrowedBooks();

        model.addAttribute("borrowed_books", borrowedBooks);
        return "list-borrows";
    }

}
