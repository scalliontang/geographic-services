package com.sicongtang.geographic.config;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ZipCodeProperties zipCodeProperties;

    @Bean(name = "zipCodeRestTemplate")
    public RestTemplate zipCodeRestTemplate(RestTemplateBuilder builder) {
        return builder.uriTemplateHandler(new DefaultUriBuilderFactory(zipCodeProperties.getGateway()))
                .setReadTimeout(Duration.ofMillis(10000))
                .setConnectTimeout(Duration.ofMillis(10000))
                .build();
    }
}
