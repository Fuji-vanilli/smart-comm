package com.fuji.order_service.webClient;

import com.fuji.order_service.model.Address;
import com.fuji.order_service.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebClientCustomer {
    private final WebClient.Builder webClient;
    private final WebClientProperties properties;

    public Customer getCustomer(String customerId) {
        CompletableFuture<String> dataFuture = webClient.build().get()
                .uri(properties.getCustomerUrl() + "/get/" + customerId)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        String dataBrute= "";
        Customer customer = null;

        try {
            dataBrute= dataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error to convert data future to string");
        }

        try {
            JSONObject jsonObject= new JSONObject(dataBrute);
            JSONObject data= jsonObject.getJSONObject("customer");
            JSONObject addressJson= data.getJSONObject("address");

            Address address= new Address(
                    addressJson.getString("street"),
                    addressJson.getString("city"),
                    addressJson.getString("country"),
                    addressJson.getString("houseNumber"),
                    addressJson.getString("postalCode")
            );

            customer= new Customer(
                    data.getString("firstname"),
                    data.getString("lastname"),
                    data.getString("email"),
                    address
            );
        } catch (JSONException e) {
            throw new RuntimeException("Error to convert data brute to json");
        }

        return customer;
    }
}
