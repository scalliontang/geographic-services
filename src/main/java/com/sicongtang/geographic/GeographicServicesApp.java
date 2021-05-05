package com.sicongtang.geographic;


import com.sicongtang.geographic.config.GeographicServicesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GeographicServicesConfig.class)
public class GeographicServicesApp {
    public static void main(String[] args) {
        SpringApplication.run(GeographicServicesApp.class, args);
    }
}
