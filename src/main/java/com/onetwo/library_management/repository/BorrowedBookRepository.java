package com.onetwo.library_management.repository;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {

    @Query("SELECT b FROM BorrowedBook b WHERE b.user.id = ?1")
    public List<BorrowedBook> findBorrowedBooksByUserId(Long id);

    @Query("SELECT b FROM BorrowedBook b WHERE b.book.id = ?1")
    public List<BorrowedBook> findBorrowedBooksByBookId(Long id);


}
