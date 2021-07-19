package com.onetwo.library_management.service;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.entity.BorrowedBook;

import java.util.List;
import java.util.Optional;

public interface BorrowedBooksService {
    public List<BorrowedBook> findAllBorrowedBooks();

    public List<BorrowedBook> findBorrowedBooksByUserId(Long id);

    public List<BorrowedBook> findBorrowedBooksByBookId(Long id);

    public Optional<BorrowedBook> findBorrowedBookById(Long id);

    public void createBorrowedBook(BorrowedBook borrowedBook);

    public void updateBorrowedBook(BorrowedBook borrowedBook);

    public void deleteBorrowedBook(Long id);

}
