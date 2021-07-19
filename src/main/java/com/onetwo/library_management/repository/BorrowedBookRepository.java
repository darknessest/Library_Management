package com.onetwo.library_management.repository;

import com.onetwo.library_management.entity.Book;
import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.entity.BorrowedBook;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {

//    @Query("SELECT b FROM Book b WHERE b.name LIKE %?1%" + " OR b.isbn LIKE %?1%" + " OR b.serialName LIKE %?1%")
//    public List<BorrowedBook> findBorrowedBooksByBook(Book book);
//
//    @Query("SELECT b FROM BorrowedBook b WHERE b.user.id = %?1%")
    @EntityGraph(value = "user.id", type = EntityGraph.EntityGraphType.FETCH)
    public List<BorrowedBook> findBorrowedBooksByUserId(Long id);

    @EntityGraph(value = "book.id", type = EntityGraph.EntityGraphType.FETCH)
    public List<BorrowedBook> findBorrowedBooksByBookId(Long id);


}
