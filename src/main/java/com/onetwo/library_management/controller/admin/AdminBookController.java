package com.onetwo.library_management.controller.admin;


import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.service.AuthorService;
import com.onetwo.library_management.service.BookService;
import com.onetwo.library_management.service.CategoryService;
import com.onetwo.library_management.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminBookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;

    @Autowired
    public AdminBookController(BookService bookService, AuthorService authorService, CategoryService categoryService,
                          PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
    }

    @GetMapping("/admin/addBook")
    public String showCreateForm(Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "add-book";
    }

    @RequestMapping("/admin/add-book")
    public String createBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookService.createBook(book);
        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/admin/updateBook/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Book book = bookService.findBookById(id);

        model.addAttribute("book", book);
        return "update-book";
    }

    @RequestMapping("/admin/update-book/{id}")
    public String updateBook(@PathVariable("id") Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update-book";
        }

        bookService.updateBook(book);
        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }

    @RequestMapping("/admin/remove-book/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBook(id);

        model.addAttribute("book", bookService.findAllBooks());
        return "redirect:/books";
    }
}
