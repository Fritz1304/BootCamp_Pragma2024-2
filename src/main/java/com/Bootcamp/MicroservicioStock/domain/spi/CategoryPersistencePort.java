package com.Bootcamp.MicroservicioStock.domain.spi;

import com.Bootcamp.MicroservicioStock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryPersistencePort {

    Category saveCategory(Category category);

    void updateCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategory(String categoriaId);

    Page<Category> findAllByOrderByNameAsc(Pageable pageable);
    Page<Category> findAllByOrderByNameDesc(Pageable pageable);
}
