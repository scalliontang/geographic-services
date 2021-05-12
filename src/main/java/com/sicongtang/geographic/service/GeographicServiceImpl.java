package com.sicongtang.geographic.service;


import com.sicongtang.geographic.mapper.GeographicMapper;
import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipcodeRequest;
import com.sicongtang.geographic.model.ZipcodeApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeographicServiceImpl implements GeographicService{
    @Autowired
    private ZipCodeService zipCodeService;

    @Override
    public LocationResponse getLocation(String zipcode) {
        ZipcodeApiResponse response = zipCodeService.getZipcodeInfo(zipcode);
        LocationResponse locationResponse = GeographicMapper.toLocationResponse(response);
        if(StringUtils.isBlank(locationResponse.getZipcode())) {
            locationResponse.setZipcode(zipcode);
        }
        return locationResponse;
    }

    @Override
    public LocationResponse[] getLocations(ZipcodeRequest request) {
        int n = request.getZipcodes().length;
        LocationResponse[] responses = new LocationResponse[n];
        for(int i = 0; i < n; i++) {
            responses[i] = getLocation(request.getZipcodes()[i]);
        }
        return responses;
    }

    //For test purpose
    public void setZipCodeService(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }
}
