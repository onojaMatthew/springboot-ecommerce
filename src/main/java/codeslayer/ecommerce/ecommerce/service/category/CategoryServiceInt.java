package codeslayer.ecommerce.ecommerce.service.category;

import codeslayer.ecommerce.ecommerce.model.Category;

import java.util.List;

public interface CategoryServiceInt {
    Category getCategoryByName(String name);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategory(Long id);
}
