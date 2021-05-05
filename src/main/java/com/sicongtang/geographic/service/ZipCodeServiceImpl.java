package com.sicongtang.geographic.service;

import com.sicongtang.geographic.model.ZipcodeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
    @Autowired
    private RestTemplate zipcodeRestTemplate;

    @Value("${api.zipcode.key}")
    private String key;

    @Value("${api.zipcode.uri}")
    private String uri;

    @Override
    public ZipcodeApiResponse getZipcodeInfo(String zipcode) {
        ZipcodeApiResponse response = null;
        try {
            ResponseEntity<ZipcodeApiResponse> responseEntity =
                    zipcodeRestTemplate.exchange(uri, HttpMethod.GET, null, ZipcodeApiResponse.class, key, zipcode);
            response = responseEntity.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
