package com.example.demo.services.category;

import com.example.demo.entities.Category;
import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategory(long id);
    List<Category> getCategories();
    Category updateCategory(Category category);
    String deleteCategory(long id);
}
