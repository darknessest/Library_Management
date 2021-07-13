package com.onetwo.library_management.controller;

import com.onetwo.library_management.entity.Author;
import com.onetwo.library_management.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping("/authors")
	public String findAllAuthors(Model model) {
		final List<Author> authors = authorService.findAllAuthors();

		model.addAttribute("authors", authors);
		return "list-authors";
	}

	@RequestMapping("/author/{id}")
	public String findAuthorById(@PathVariable("id") Long id, Model model) {
		final Author author = authorService.findAuthorById(id);

		model.addAttribute("author", author);
		return "list-authors";
	}



}
