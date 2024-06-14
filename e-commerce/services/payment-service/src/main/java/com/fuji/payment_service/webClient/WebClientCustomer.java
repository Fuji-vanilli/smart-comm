package com.fuji.payment_service.webClient;

import com.fuji.payment_service.models.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebClientCustomer {
    private final WebClient.Builder webClient;
    private final WebClientProperties properties;

    public Customer getCustomer(String customerId) {
        CompletableFuture<String> dataFuture = webClient.build().get()
                .uri(properties.getGetURL() + "/" + customerId)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        String dataBrute= "";
        Customer customer = null;

        try {
            dataBrute= dataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error getting customer data", e);
        }

        try {
            JSONObject jsonObject = new JSONObject(dataBrute);
            JSONObject data = jsonObject.getJSONObject("customer");

            customer= new Customer(
                    data.getString("firstname"),
                    data.getString("lastname"),
                    data.getString("email")
            );

        } catch (JSONException e) {
            throw new RuntimeException("Error to serialize data of customer to JSON", e);
        }

        return customer;
    }
}
