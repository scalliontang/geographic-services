package com.sicongtang.geographic.mapper;

import com.sicongtang.geographic.model.LocationResponse;
import com.sicongtang.geographic.model.ZipcodeApiResponse;

public class GeographicMapper {

    public static LocationResponse toLocationResponse(ZipcodeApiResponse zipcodeApi) {
        LocationResponse response = new LocationResponse();
        response.setCity(zipcodeApi.getCity());
        response.setState(zipcodeApi.getState());
        response.setZipcode(zipcodeApi.getZipcode());
        response.setTimezone(zipcodeApi.getTimezone().getTimezoneAbbr());
        return response;
    }
}
