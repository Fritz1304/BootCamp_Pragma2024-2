package com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.adapter;

import com.Bootcamp.MicroservicioStock.domain.model.Category;
import com.Bootcamp.MicroservicioStock.domain.spi.CategoryPersistencePort;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.CategoryAlreadyExistsException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.DescriptionNotFoundException;
import com.Bootcamp.MicroservicioStock.infraestructure.exception.NoDataFoundException;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.entity.CategoryEntity;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.mapper.CategoryMapper;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Category saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        } else if (category.getDescripcion().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        CategoryEntity categoryEntity = this.categoryRepository.save(
                categoryMapper.toCategoryEntity(category)
        );
        return categoryMapper.toCategory(categoryEntity);
    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()){throw new NoDataFoundException();}

        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::toCategory)
                .collect(Collectors.toList()
                );
    }

    @Override
    public void deleteCategory(String Id) {
        categoryRepository.deleteByName(Id);
    }

    @Override
    public Page<Category> findAllByOrderByNameAsc(Pageable pageable) {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()){throw new NoDataFoundException();}

        return categoryRepository.findAllByOrderByNameAsc(pageable).map(categoryMapper::toCategory);
    }

    @Override
    public Page<Category> findAllByOrderByNameDesc(Pageable pageable) {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()){throw new NoDataFoundException();}

        return categoryRepository.findAllByOrderByNameDesc(pageable).map(categoryMapper::toCategory);
    }

}



