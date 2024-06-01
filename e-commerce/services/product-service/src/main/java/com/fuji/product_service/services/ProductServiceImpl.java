package com.fuji.product_service.services;

import com.fuji.product_service.dto.ProductRequest;
import com.fuji.product_service.mapper.ProductMapper;
import com.fuji.product_service.repositories.ProductRepository;
import com.fuji.product_service.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
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
        return null;
    }

    @Override
    public Response get(String idProduct) {
        return null;
    }

    @Override
    public Response getAllProducts() {
        return null;
    }

    @Override
    public Response delete(String idProduct) {
        return null;
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
