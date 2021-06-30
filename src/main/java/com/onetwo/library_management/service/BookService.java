package com.onetwo.library_management.service;

import com.onetwo.library_management.model.Book;

import java.util.List;

public interface BookService {
    abstract List<Book> getBooks();

    abstract boolean saveBook(Book book);

    abstract Book getBookById(String id);

    abstract Book getBookByISBN(String ISBN);

    abstract List<Book> getBooksByAuthor(String author);
}
