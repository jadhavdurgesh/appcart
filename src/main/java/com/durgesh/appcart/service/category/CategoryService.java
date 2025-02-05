package com.durgesh.appcart.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.durgesh.appcart.exceptions.AlreadyExistException;
import com.durgesh.appcart.exceptions.ProductNotFoundException;
import com.durgesh.appcart.exceptions.ResourceNotFoundException;
import com.durgesh.appcart.model.Category;
import com.durgesh.appcart.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new AlreadyExistException(category.getName() + "Category Already Exists!"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id))
                .map(oldCategory -> {
                    oldCategory.setName(category.getName());
                    return categoryRepository.save(oldCategory);
                }).orElseThrow(() -> new ResourceNotFoundException("Category Not Found!"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {
            throw new ResourceNotFoundException("Category Not Found!");
        });
    }

}