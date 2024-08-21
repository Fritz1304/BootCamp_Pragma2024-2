package com.Bootcamp.MicroservicioStock.application.mapper;

import com.Bootcamp.MicroservicioStock.application.dto.CategoryDto;
import com.Bootcamp.MicroservicioStock.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryRequest {

    Category toCategory(CategoryDto category);
    CategoryDto toCategoryDto(Category categoryDto);

}
