package com.fuji.order_service.webClient;

import com.fuji.order_service.model.ProductPurchaseRequest;
import com.fuji.order_service.model.ProductPurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Configuration
@RequiredArgsConstructor
public class WebClientProduct {
    private final WebClient.Builder webClient;
    private final WebClientProperties properties;

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests) {
        return webClient.build().patch()
                .uri(properties.getProductUrl() + "/purchase")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requests))
                .retrieve()
                .bodyToFlux(ProductPurchaseResponse.class)
                .collectList()
                .block();
    }
}
