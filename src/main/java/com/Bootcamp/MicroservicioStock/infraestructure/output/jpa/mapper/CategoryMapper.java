package com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.mapper;
import com.Bootcamp.MicroservicioStock.domain.model.Category;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.entity.CategoryEntity;
import  org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryEntity category);
    CategoryEntity toCategoryEntity(Category category);
}
