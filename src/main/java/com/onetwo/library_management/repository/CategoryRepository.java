package com.onetwo.library_management.repository;

import com.onetwo.library_management.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
