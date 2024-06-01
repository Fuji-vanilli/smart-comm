package com.fuji.product_service.services;

import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.entities.Product;
import com.fuji.product_service.exception.ProductNotFoundException;
import com.fuji.product_service.mapper.ProductMapper;
import com.fuji.product_service.repositories.CategoryRepository;
import com.fuji.product_service.repositories.ProductRepository;
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
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public Response createProduct(ProductRequest request) {
        if (productRepository.existsByName(request.name())) {
            log.error("Product with name {} already exists", request.name());
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Product with name " + request.name() + " already exists"
            );
        }

        var product= productMapper.mapToProduct(request);
        product.setId(UUID.randomUUID().toString());
        product.setCreateDate(new Date());
        product.setLastUpdateDate(new Date());

        productRepository.save(product);
        log.info("Created product {}", product);

        return generateResponse(
                HttpStatus.CREATED,
                Map.of(
                        "product", productMapper.mapToProductResponse(product)
                ),
                "new Product created"
        );
    }

    @Override
    public Response updateProduct(ProductRequest request) {
        var product= productRepository.findByName(request.name())
                .orElseThrow(
                        ()-> new ProductNotFoundException(
                                format("Can't update product:: No product found with the ID:: %s", request.name()))
                );

        mergerProduct(product, request);

        product.setLastUpdateDate(new Date());
        productRepository.save(product);

        log.info("product updated successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "product", productMapper.mapToProductResponse(product)
                ),
                "product updated successfully!"
        );
    }

    private void mergerProduct(Product product, ProductRequest request) {
        if (StringUtils.isNotBlank(request.name())) {
            product.setName(request.name());
        }
        if (StringUtils.isNotBlank(request.description())) {
            product.setDescription(request.description());
        }
        if (StringUtils.isNotBlank(request.categoryId())) {
            product.setDescription(request.categoryId());
        }
        if (request.price()!= null) {
            product.setPrice(request.price());
        }
    }

    @Override
    public Response get(String idProduct) {
        var product= productRepository.findById(idProduct);
        if (product.isEmpty()) {
            log.error("Can't find product:: No product found with ID:: {}",idProduct );
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Can't find product:: No product found with ID:: "+idProduct
            );
        }

        log.info("product with the id: {} finding successfully", idProduct);
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "product", productMapper.mapToProductResponse(product.get())
                ),
                "product with the id: "+idProduct+" finding successfully"
        );
    }

    @Override
    public Response getAllProducts() {
        List<Product> allProduct = productRepository.findAll();
        if (allProduct.isEmpty()) {
            log.error("no product into the database!");
            return generateResponse(
                  HttpStatus.BAD_REQUEST,
                  null,
                  "no product into the database"
            );
        }

        log.info("all product finding successfully!");
        return generateResponse(
                HttpStatus.OK,
                Map.of(
                        "products", allProduct.stream()
                                .map(productMapper::mapToProductResponse)
                                .toList()
                ),
                "all product finding successfully!"
        );
    }

    @Override
    public Response delete(String idProduct) {
        var product= productRepository.findById(idProduct);
        if (product.isEmpty()) {
            log.error("Can't delete product:: No product found with ID:: {}",idProduct );
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    "Can't delete product:: No product found with ID:: "+idProduct
            );
        }

        productRepository.deleteById(idProduct);
        log.info("product with the id: {} deleted successfully", idProduct);

        return generateResponse(
                HttpStatus.OK,
                null,
                "product with the id: "+idProduct+" deleted successfully"
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
