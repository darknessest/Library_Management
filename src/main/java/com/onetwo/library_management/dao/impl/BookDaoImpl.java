package com.onetwo.library_management.dao.impl;

import com.onetwo.library_management.dao.BookDao;
import com.onetwo.library_management.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getBooks() {
        Query query = em.createQuery("select a from book_t a");
        List<Book> result = query.getResultList();
        return result;
    }

    @Override
    public boolean saveBook(Book account) {
        em.persist(account);
        return true;
    }

    @Override
    public Book getBookById(String id) {
        Query query = em.createQuery("SELECT a FROM book_t a where a.id=:id");
        query.setParameter("id", id);
        System.out.println("book id=" + id);
        Book result = (Book) query.getSingleResult();
        return result;
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        Query query = em.createQuery("SELECT a FROM book_t a where a.ISBN=:ISBN");
        query.setParameter("ISBN", ISBN);
        System.out.println("book ISBN=" + ISBN);
        Book result = (Book) query.getSingleResult();
        return result;
    }


    /**
     * Returns books with author LIKE the `author` argument
     */
    @Override
    public List<Book> getBooksByAuthor(String author) {
        Query query = em.createQuery("SELECT a FROM book_t a where a.author like :author");
        query.setParameter("author", author);
        System.out.println("book author=" + author);
        List<Book> result = query.getResultList();
        return result;
    }
}
