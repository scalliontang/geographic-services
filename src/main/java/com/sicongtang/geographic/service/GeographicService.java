package com.sicongtang.geographic.service;

import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipCodeRequest;

public interface GeographicService {
    public LocationResponse getLocation(String zipcode);
    public LocationResponse[] getLocations(ZipCodeRequest request);
}
