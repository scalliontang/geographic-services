package com.sicongtang.geographic.rest;


import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.service.GeographicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class GeographicController {

    private static final Logger LOG = LoggerFactory.getLogger(GeographicController.class);

    @Autowired
    private GeographicService geographicService;

    @GetMapping("/ping")
    public String ping() {
        return "Geographic service is running successfully";
    }

    @GetMapping("/{zipcode}")
    public ResponseEntity<LocationResponse> getLocationFromZipCode(@PathVariable("zipcode") String zipcode) {
        LOG.debug("Received a request to get location of zipcode {}", zipcode);
        LocationResponse response = geographicService.getLocation(zipcode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
