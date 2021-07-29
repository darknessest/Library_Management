package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.BorrowedBook;
import com.onetwo.library_management.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@AllArgsConstructor
public class BookController {
	private final BookService bookService;
	private final CategoryService categoryService;
	private final AuthorService authorService;
	private final PublisherService publisherService;
//	private final BorrowedBooksService borrowedBooksService;

	@RequestMapping("/books")
	public String findAllBooks(Model model) {
		final List<Book> books = bookService.findAllBooks();
		Book new_book = new Book();
		BorrowedBook new_borrow = new BorrowedBook();
//		final List<BorrowedBook> borrowedBooks = borrowedBooksService.findAllBorrowedBooks();

//		model.addAttribute("borrowed_books", borrowedBooks);
		model.addAttribute("books", books);

		model.addAttribute("categories", categoryService.findAllCategories());
		model.addAttribute("authors", authorService.findAllAuthors());
		model.addAttribute("publishers", publisherService.findAllPublishers());

		model.addAttribute("new_book", new_book);
		model.addAttribute("new_borrow", new_borrow);
		return "list-books";
	}

	@RequestMapping("/searchBook")
	public String searchBook(@Param("keyword") String keyword, Model model) {
		final List<Book> books = bookService.searchBooks(keyword);

		model.addAttribute("books", books);
		model.addAttribute("keyword", keyword);
		return "list-books";
	}

	@RequestMapping("/book/{id}")
	public String findBookById(@PathVariable("id") Long id, Model model) {
		final Book book = bookService.findBookById(id);

		model.addAttribute("book", book);
		return "list-book";
	}


}
