package com.fuji.order_service.webClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "web-client.config")
public class WebClientProperties {
    private String customerUrl;
    private String productUrl;
    private String paymentUrl;
}
