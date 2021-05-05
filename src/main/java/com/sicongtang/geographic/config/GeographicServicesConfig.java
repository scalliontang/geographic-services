package com.sicongtang.geographic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriTemplateHandler;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.sicongtang.geographic")
public class GeographicServicesConfig {

    @Value("${api.zipcode.gateway}")
    private String gateway;

    @Bean(name = "zipCodeRestTemplate")
    public RestTemplate zipCodeRestTemplate(RestTemplateBuilder builder) {
        return builder.uriTemplateHandler(new DefaultUriBuilderFactory(gateway))
                .setReadTimeout(Duration.ofMillis(10000))
                .setConnectTimeout(Duration.ofMillis(10000))
                .build();
    }
}
