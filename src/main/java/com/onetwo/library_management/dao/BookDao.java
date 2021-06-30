package com.onetwo.library_management.dao;

import com.onetwo.library_management.model.Book;

import java.util.List;

public interface BookDao {
    abstract List<Book> getBooks();

    abstract boolean saveBook(Book account);

    abstract Book getBookById(String id);

    abstract Book getBookByISBN(String ISBN);

    abstract List<Book> getBooksByAuthor(String ISBN);
}
