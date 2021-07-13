//package com.onetwo.library_management.service.impl;
//
//import com.onetwo.library_management.entity.Book;
//import com.onetwo.library_management.entity.User;
//import com.onetwo.library_management.entity.BorrowedBook;
//import com.onetwo.library_management.exception.NotFoundException;
//import com.onetwo.library_management.repository.BorrowedBookRepository;
//import com.onetwo.library_management.service.BorrowedBooksService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class BorrowedBooksServiceImpl implements BorrowedBooksService {
//
//    private final BorrowedBookRepository borrowedBookRepository;
//
//    @Override
//    public List<BorrowedBook> findBorrowedBooks() {
//        return borrowedBookRepository.findAll();
//    }
//
//    @Override
//    public List<BorrowedBook> findBorrowedBooksByUserId(Long id) {
//        return borrowedBookRepository.findBorrowedBooksByUserId(id);
//    }
//
//    @Override
//    public List<BorrowedBook> findBorrowedBooksByBookId(Long id) {
//        return borrowedBookRepository.findBorrowedBooksByBookId(id);
//    }
//
//    @Override
//    public Optional<BorrowedBook> findBorrowedBookById(Long id) {
//        return borrowedBookRepository.findById(id);
//    }
//
//    @Override
//    public void createdBorrowedBook(BorrowedBook book) {
//        borrowedBookRepository.save(book);
//    }
//
//    @Override
//    public void updateBorrowedBook(BorrowedBook book) {
//        borrowedBookRepository.save(book);
//    }
//
//    @Override
//    public void deleteBorrowedBook(Long id) {
//
//        final BorrowedBook borrowedBook = borrowedBookRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
//
//        borrowedBookRepository.deleteById(borrowedBook.getId());
//    }
//}
