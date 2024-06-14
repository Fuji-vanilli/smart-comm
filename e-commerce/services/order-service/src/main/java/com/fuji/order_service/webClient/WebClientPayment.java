package com.fuji.order_service.webClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuji.order_service.dto.Payment;
import com.fuji.order_service.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebClientPayment {
    private final WebClient.Builder webClient;
    private final WebClientProperties properties;

    public boolean requestOrderPayment(PaymentRequest request) {
        CompletableFuture<String> future = webClient.build().post()
                .uri(properties.getPaymentUrl() + "/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        String dataBrute= "";
        boolean isPaymentSuccess = false;

        try {
            dataBrute= future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("error when request order payment", e);
        }

        try {
            JSONObject jsonObject= new JSONObject(dataBrute);
            JSONObject data= jsonObject.getJSONObject("payment");

            if (data.getInt("status") == 201) {
                isPaymentSuccess = true;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return isPaymentSuccess;
    }
}
