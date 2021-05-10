package com.sicongtang.geographic.rest;


import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipcodeRequest;
import com.sicongtang.geographic.service.GeographicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@Api(value = "Location Services")
public class GeographicController {

    private static final Logger LOG = LoggerFactory.getLogger(GeographicController.class);

    @Autowired
    private GeographicService geographicService;

    @GetMapping("/ping")
    public String ping() {
        return "Geographic service is running successfully";
    }

    @GetMapping(value = "/{zipcode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Location by zipcode", response = LocationResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = LocationResponse.class, message = "Successful response"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    public ResponseEntity<LocationResponse> getLocationFromZipCode(@PathVariable("zipcode") String zipcode) {
        LOG.debug("Received a request to get location of zipcode {}", zipcode);
        LocationResponse response = geographicService.getLocation(zipcode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find Location by zipcode", response = LocationResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = LocationResponse.class, message = "Successful response"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    public ResponseEntity<LocationResponse[]> getMultipleLocations(@RequestBody ZipcodeRequest request) {
        LOG.debug("Received a request to get multiple zipcodes");
        LocationResponse[] response = geographicService.getLocations(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
