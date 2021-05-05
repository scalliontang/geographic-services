package com.sicongtang.geographic.service;

import com.sicongtang.geographic.model.LocationResponse;

public interface GeographicService {
    public LocationResponse getLocation(String zipcode);
}
