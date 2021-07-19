package com.onetwo.library_management.service;

import com.onetwo.library_management.entity.BorrowedBook;

import java.util.List;

public interface BorrowedBooksService {
    public List<BorrowedBook> findAllBorrowedBooks();

    public List<BorrowedBook> findBorrowedBooksByUserId(Long id);

    public List<BorrowedBook> findBorrowedBooksByBookId(Long id);

    public BorrowedBook findBorrowedBookById(Long id);

    public void createBorrowedBook(BorrowedBook borrowedBook);

    public void updateBorrowedBook(BorrowedBook borrowedBook);

    public void saveBorrowedBook(BorrowedBook borrowedBook);

    public void deleteBorrowedBook(Long id);

}
