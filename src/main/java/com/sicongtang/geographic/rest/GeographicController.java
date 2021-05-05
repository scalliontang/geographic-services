package com.sicongtang.geographic.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class GeographicController {

    @GetMapping("/ping")
    public String ping() {
        return "Geographic service is running successfully";
    }
}
