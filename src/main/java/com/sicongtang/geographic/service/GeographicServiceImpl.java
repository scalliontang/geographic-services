package com.sicongtang.geographic.service;


import com.sicongtang.geographic.mapper.GeographicMapper;
import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipcodeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeographicServiceImpl implements GeographicService{
    @Autowired
    private ZipCodeService zipCodeService;

    @Override
    public LocationResponse getLocation(String zipcode) {
        ZipcodeApiResponse response = zipCodeService.getZipcodeInfo(zipcode);
        return GeographicMapper.toLocationResponse(response);
    }
}
