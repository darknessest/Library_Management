package com.onetwo.library_management.components;

import com.onetwo.library_management.controller.admin.AdminBookController;
import com.onetwo.library_management.entity.*;
import com.onetwo.library_management.repository.BookRepository;
import com.onetwo.library_management.repository.BorrowedBookRepository;
import com.onetwo.library_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        // add users
        User user = new User();
        user.setUsername("admin");
        user.setName("preregistered admin");
        user.setPhone("123456789011");
        user.setEmail("admin@mail.com");
        user.setPassword(passwordEncoder.encode("adminPass"));
        user.setUserRole(UserRole.ADMIN);

        userRepository.save(user);

        user = new User();
        user.setUsername("user1");
        user.setName("preregistered user");
        user.setPhone("110987654321");
        user.setEmail("user1@mail.com");
        user.setPassword(passwordEncoder.encode("user1Pass"));
        user.setUserRole(UserRole.USER);

        userRepository.save(user);

        // create books
        Book book = new Book("Test isbn", "Test name", "Test serial name", "Test description", 12.5);
        Author author = new Author("Test author name", "Test description");
        Category category = new Category("Test category name");
        Publisher publisher = new Publisher("Test publisher name");

        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);

        bookRepository.save(book);

        Book book1 = new Book("Test isbn1", "Test name1", "Test serial name1", "Test description1", 22.0);
        Author author1 = new Author("Test author name1", "Test description1");
        Category category1 = new Category("Test category name1");
        Publisher publisher1 = new Publisher("Test publisher name1");

        book1.addAuthors(author1);
        book1.addCategories(category1);
        book1.addPublishers(publisher1);

        bookRepository.save(book1);

        Book book2 = new Book("Test isbn2", "Test name2", "Test serial name2", "Test description2", 27.3);
        Author author2 = new Author("Test author name2", "Test description2");
        Category category2 = new Category("Test category name2");
        Publisher publisher2 = new Publisher("Test publisher name2");

        book2.addAuthors(author2);
        book2.addCategories(category2);
        book2.addPublishers(publisher2);

        bookRepository.save(book2);
    }
}