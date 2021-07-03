package com.onetwo.library_management.repository;

import com.onetwo.library_management.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}
