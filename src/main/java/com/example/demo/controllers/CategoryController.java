package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.services.category.CategoryServiceImpl;
import com.example.demo.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories/")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(path = "/category/{id}")
    public Category findCategoryByID(@PathVariable long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping(path = "/{id}/")
    public Category updateCategory(@PathVariable long id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCategory(@PathVariable long id) {
        return categoryService.deleteCategory(id);
    }

}