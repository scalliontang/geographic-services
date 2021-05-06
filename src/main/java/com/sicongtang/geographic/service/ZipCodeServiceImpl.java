package com.sicongtang.geographic.service;

import com.sicongtang.geographic.config.ZipCodeProperties;
import com.sicongtang.geographic.model.ZipcodeApiResponse;
import com.sicongtang.geographic.rest.GeographicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    private static final Logger LOG = LoggerFactory.getLogger(ZipCodeServiceImpl.class);
    @Autowired
    private RestTemplate zipcodeRestTemplate;

    @Autowired
    private ZipCodeProperties zipCodeProperties;

    @Override
    public ZipcodeApiResponse getZipcodeInfo(String zipcode) {
        ZipcodeApiResponse response = null;
        try {
            ResponseEntity<ZipcodeApiResponse> responseEntity =
                    zipcodeRestTemplate.exchange(zipCodeProperties.getUri(), HttpMethod.GET, null, ZipcodeApiResponse.class, zipCodeProperties.getKey(), zipcode);
            response = responseEntity.getBody();
            LOG.debug("Successully retrieved response from zipcodeapi.com");
        } catch (Exception e) {
            LOG.error("Exception from zipcodeapi.com {}", e.getMessage());
        }
        return response;
    }
}
