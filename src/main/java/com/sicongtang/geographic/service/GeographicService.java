package com.sicongtang.geographic.service;

import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipcodeRequest;

public interface GeographicService {
    public LocationResponse getLocation(String zipcode);
    public LocationResponse[] getLocations(ZipcodeRequest request);
}
