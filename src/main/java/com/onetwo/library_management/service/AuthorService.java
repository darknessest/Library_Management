package com.onetwo.library_management.service;

import com.onetwo.library_management.entity.Author;

import java.util.List;


public interface AuthorService {

	public List<Author> findAllAuthors();

	public Author findAuthorById(Long id);

	public void createAuthor(Author author);

	public void updateAuthor(Author author);

	public void deleteAuthor(Long id);

}
