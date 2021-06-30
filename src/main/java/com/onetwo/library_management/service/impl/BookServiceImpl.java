package com.onetwo.library_management.service.impl;

import com.onetwo.library_management.dao.BookDao;
import com.onetwo.library_management.model.Book;
import com.onetwo.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public boolean saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    @Override
    public Book getBookById(String id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        return bookDao.getBookByISBN(ISBN);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookDao.getBooksByAuthor(author);
    }
}
