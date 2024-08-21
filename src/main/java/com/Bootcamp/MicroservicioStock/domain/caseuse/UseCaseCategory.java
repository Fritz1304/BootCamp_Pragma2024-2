package com.Bootcamp.MicroservicioStock.domain.caseuse;

import com.Bootcamp.MicroservicioStock.domain.api.ICategoryServicePort;
import com.Bootcamp.MicroservicioStock.domain.exception.DescriptionTooLongException;
import com.Bootcamp.MicroservicioStock.domain.exception.NameIsTooLongException;
import com.Bootcamp.MicroservicioStock.domain.model.Category;
import com.Bootcamp.MicroservicioStock.domain.spi.CategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public class UseCaseCategory implements ICategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public UseCaseCategory(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category saveCategory(Category category) {
        if (category.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (category.getDescripcion().length() > 90) {
           throw new DescriptionTooLongException();   }
        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }

    @Override
    public void updateCategory(Category category) {
        if (category.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (category.getDescripcion().length() > 90) {
            throw new DescriptionTooLongException();
       }
        categoryPersistencePort.saveCategory(category);

    }

    @Override
    public void deleteCategory(String categoryId) {

    }

    @Override
    public Page<Category> findAllByOrderByNameAsc(Pageable pageable) {
        return categoryPersistencePort.findAllByOrderByNameAsc(pageable);
    }

    @Override
    public Page<Category> findAllByOrderByNameDesc(Pageable pageable) {
        return categoryPersistencePort.findAllByOrderByNameDesc(pageable);
    }
}
