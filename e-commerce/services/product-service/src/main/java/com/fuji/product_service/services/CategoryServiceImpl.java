package com.fuji.product_service.services;

import com.fuji.product_service.dto.CategoryRequest;
import com.fuji.product_service.entities.Category;
import com.fuji.product_service.entities.Product;
import com.fuji.product_service.exception.ProductNotFoundException;
import com.fuji.product_service.mapper.CategoryMapper;
import com.fuji.product_service.repositories.CategoryRepository;
import com.fuji.product_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.lang.String.format;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Response create(CategoryRequest request) {
        if (categoryRepository.existsByName(request.name())) {
            log.error("Category with name {} already exists", request.name());
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Category with name " + request.name() + " already exists"
            );
        }

        var category= categoryMapper.mapToCategory(request);
        category.setId(UUID.randomUUID().toString());
        category.setCreatedDate(new Date());
        category.setLastUpdatedDate(new Date());

        categoryRepository.save(category);
        log.info("category category {}", category);

        return generateResponse(
                HttpStatus.CREATED,
                Map.of(
                        "product", categoryMapper.mapToCategoryResponse(category)
                ),
                "new Category created"
        );
    }

    @Override
    public Response update(CategoryRequest request) {
        var category= categoryRepository.findByName(request.name())
                .orElseThrow(
                        ()-> new ProductNotFoundException(
                                format("Can't update category:: No category found with the ID:: %s", request.name()))
                );

        mergerCategory(category, request);

        category.setLastUpdatedDate(new Date());
        categoryRepository.save(category);

        log.info("category updated successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "product", categoryMapper.mapToCategoryResponse(category)
                ),
                "category updated successfully!"
        );
    }

    private void mergerCategory(Category category, CategoryRequest request) {
        if (StringUtils.isNotBlank(request.name())) {
            category.setName(request.name());
        }
        if (StringUtils.isNotBlank(request.description())) {
            category.setDescription(request.description());
        }
    }

    @Override
    public Response get(String idCategory) {
        var category= categoryRepository.findById(idCategory);
        if (category.isEmpty()) {
            log.error("Can't find category:: No category found with ID:: {}",idCategory );
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Can't find category:: No category found with ID:: "+idCategory
            );
        }

        log.info("category with the id: {} finding successfully", idCategory);
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "category", categoryMapper.mapToCategoryResponse(category.get())
                ),
                "product with the id: "+idCategory+" finding successfully"
        );
    }

    @Override
    public Response getAllProducts() {
        List<Category> allCategory = categoryRepository.findAll();
        if (allCategory.isEmpty()) {
            log.error("no category into the database!");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "no category into the database"
            );
        }

        log.info("all category finding successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "products", allCategory.stream()
                                .map(categoryMapper::mapToCategoryResponse)
                                .toList()
                ),
                "all category finding successfully!"
        );
    }

    @Override
    public Response delete(String idCategory) {
        var category= categoryRepository.findById(idCategory);
        if (category.isEmpty()) {
            log.error("Can't delete category:: No category found with ID:: {}",idCategory );
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Can't delete category:: No category found with ID:: "+idCategory
            );
        }

        categoryRepository.deleteById(idCategory);
        log.info("category with the id: {} deleted successfully", idCategory);

        return generateResponse(
                HttpStatus.OK,
                null,
                "category with the id: "+idCategory +" deleted successfully"
        );
    }
    private Response generateResponse(HttpStatus status, Map<?, ?> data, String message) {
        return Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .data(data)
                .message(message)
                .build();
    }
}
