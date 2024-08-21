package com.Bootcamp.MicroservicioStock.infraestructure.configuration;
import com.Bootcamp.MicroservicioStock.domain.api.ICategoryServicePort;
import com.Bootcamp.MicroservicioStock.domain.caseuse.UseCaseCategory;
import com.Bootcamp.MicroservicioStock.domain.spi.CategoryPersistencePort;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.adapter.CategoryJpaAdapter;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.mapper.CategoryMapper;
import com.Bootcamp.MicroservicioStock.infraestructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Bean
    public CategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new UseCaseCategory(categoryPersistencePort());
    }
}