package com.fuji.payment_service.webClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web.client.customer")
@Data
@AllArgsConstructor @NoArgsConstructor
public class WebClientProperties {
    private String getURL;
}
