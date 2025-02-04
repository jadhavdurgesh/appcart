package com.durgesh.appcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.appcart.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}