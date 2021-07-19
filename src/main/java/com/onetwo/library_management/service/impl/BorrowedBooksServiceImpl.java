package com.onetwo.library_management.service.impl;

import com.onetwo.library_management.entity.BorrowedBook;
import com.onetwo.library_management.exception.NotFoundException;
import com.onetwo.library_management.repository.BorrowedBookRepository;
import com.onetwo.library_management.service.BorrowedBooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowedBooksServiceImpl implements BorrowedBooksService {

    private final BorrowedBookRepository borrowedBookRepository;

    @Override
    public List<BorrowedBook> findAllBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public List<BorrowedBook> findBorrowedBooksByUserId(Long id) {
        return borrowedBookRepository.findBorrowedBooksByUserId(id);
    }

    @Override
    public List<BorrowedBook> findBorrowedBooksByBookId(Long id) {
        return borrowedBookRepository.findBorrowedBooksByBookId(id);
    }

    @Override
    public BorrowedBook findBorrowedBookById(Long id) {
        return borrowedBookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Book not found borrow with ID %d", id)));
    }

    @Override
    public void createBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public void updateBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public void saveBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public void deleteBorrowedBook(Long id) {

        final BorrowedBook borrowedBook = borrowedBookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

        borrowedBookRepository.deleteById(borrowedBook.getId());
    }
}
