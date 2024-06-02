package com.fuji.product_service;

import com.fuji.product_service.entities.Category;
import com.fuji.product_service.entities.Product;
import com.fuji.product_service.repositories.CategoryRepository;
import com.fuji.product_service.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(ProductRepository repository, CategoryRepository categoryRepository) {
		return args -> {
			Product product= Product.builder()
					.id("1234")
					.price(new BigDecimal(12500))
					.availableQuantity(12)
					.name("iphone")
					.build();

			repository.save(product);

			categoryRepository.save(Category.builder()
							.id("2354")
							.name("phone")
							.description("cat-2")
							.products(List.of(product))
					.build());
		};
	}
}
