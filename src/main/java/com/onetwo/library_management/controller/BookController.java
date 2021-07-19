package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.service.AuthorService;
import com.onetwo.library_management.service.BookService;
import com.onetwo.library_management.service.CategoryService;
import com.onetwo.library_management.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller

public class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String findAllBooks(Model model) {
		final List<Book> books = bookService.findAllBooks();

		model.addAttribute("books", books);
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
